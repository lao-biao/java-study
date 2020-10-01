package com.training.day09;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周超
 * @title LoginServlet
 * @date 2020/7/23 16:44
 * @description 处理登录页面的请求
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -3352221258084156181L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式
        req.setCharacterEncoding("UTF-8");
        // 获取请求内容：用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
    }
}
