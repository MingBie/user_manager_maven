package com.user.manager.web;

import com.user.manager.entity.User;
import com.user.manager.service.UserService;
import com.user.manager.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/UpdateUserByIdServlet")
public class UpdateUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        request.setCharacterEncoding("UTF-8");
/*        int id = Integer.valueOf(request.getParameter("id"));*/
        // 接收请求 获得请求数据
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 调用service中 通过id修改用户信息的方法
        UserService userService = new UserServiceImpl();
        userService.updateUserById(user);
        // 跳转 所有用户页面list 并显示 (重定向)
        response.sendRedirect(request.getContextPath() + "/FindByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
