package com.user.manager.web;

import com.user.manager.entity.User;
import com.user.manager.service.UserService;
import com.user.manager.service.impl.UserServiceImpl;
import com.user.manager.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindByPageServlet")
public class FindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 接收条件
        Map<String, String[]> condition = request.getParameterMap();
        // 接收 当前页数和每页显示条数
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        // 判断 当前页数和每页显示条数 是否为空
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (pageSize == null || "".equals(pageSize)) {
            pageSize = "4";
        }
        UserService us = new UserServiceImpl();
        // 调用 service 获得 分页对象
        PageBean<User> pageBean = us.findByPageUser(currentPage, pageSize, condition);
        // 转发 jsp显示
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
