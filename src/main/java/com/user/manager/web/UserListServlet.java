package com.user.manager.web;

import com.user.manager.entity.User;
import com.user.manager.service.UserService;
import com.user.manager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收请求 调用service中 查询所有用户信息的方法
        UserService userService = new UserServiceImpl();
        List<User> list = userService.findAll();
        // 2. 返回用户信息 给list.jsp
        request.setAttribute("list",list);
        // 3. 转发 跳转页面
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
