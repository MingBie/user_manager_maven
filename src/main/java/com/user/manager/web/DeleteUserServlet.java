package com.user.manager.web;

import com.user.manager.service.UserService;
import com.user.manager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求 获得id
        int id = Integer.valueOf(request.getParameter("id"));
        // 调用service 通过id删除用户的方法
        UserService userService = new UserServiceImpl();
        userService.deleteUserById(id);
        // 跳转 所有用户页面list 并显示 (重定向)
        response.sendRedirect(request.getContextPath() + "/FindByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
