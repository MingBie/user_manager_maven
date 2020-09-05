package com.user.manager.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
// 权限设置(过滤器)
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 获得 请求路径
        String uri = request.getRequestURI();
        // 判断是否是 登录操作
        // 判断是否是 验证码
        if (uri.contains("login.jsp") || uri.contains("LoginServlet") || uri.contains("CheckImgServlet")
                || uri.contains(".js") || uri.contains(".css")) {
            chain.doFilter(req, resp);
        } else {
            // 判断 是否已经登录
            // 如果已经登录 则放行
            // 反之 则跳转 登录界面
            if (request.getSession().getAttribute("user") != null) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
