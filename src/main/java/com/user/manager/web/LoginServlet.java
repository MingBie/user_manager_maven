package com.user.manager.web;

import com.user.manager.entity.User;
import com.user.manager.service.UserService;
import com.user.manager.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import sun.tools.jconsole.JConsole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 先判断验证码
        String verifycode = request.getParameter("verifycode");
        String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
        if (checkcode_session.equals(verifycode)) {
            // 1. 接收请求的数据
            User user = new User();
            try {
                BeanUtils.populate(user,request.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            // 2. 调用service中 login方法
            UserService userService = new UserServiceImpl();
            try {
                User loginUser = userService.login(user);
                // 3. 登入成功页面跳转
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                // 4. 把数据存入Session中
                request.getSession().setAttribute("user",loginUser);
            } catch (Exception e) {
                // 登入失败页面也跳转
                request.setAttribute("error",e.getMessage());
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } else {
            // 登入失败页面也跳转
            request.setAttribute("error","验证码输入错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
