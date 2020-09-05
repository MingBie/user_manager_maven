package com.user.manager.web;

import com.user.manager.service.UserService;
import com.user.manager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteSelectUserServlet")
public class DeleteSelectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求 获得id
        String[] ids = request.getParameterValues("id");
        UserService userService = new UserServiceImpl();
        // 调用 service
        userService.deleteSelectUser(ids);
        // jsp 进行显示
        response.sendRedirect(request.getContextPath() + "/FindByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
