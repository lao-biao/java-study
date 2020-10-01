package com.study.traning.controller;

import com.study.traning.pojo.UserEntity;
import com.study.traning.service.UserService;
import com.study.traning.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 周超
 * @title LoginServlet
 * @date 2020/7/24 15:46
 * @description 用户登录处理
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    // 处理相关的请求
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 获取请求参数
        Object username = req.getParameter("username");
        // System.out.println(username);
        Object password = req.getParameter("password");
        // System.out.println(password);
        if (username != null && !username.equals("")) {
            // System.out.println("Servlet开始校验用户信息");
            // 校验用户信息
            UserEntity user = userService.checkUser((String) username);
            // 用户登录信息正确
            if (user != null && user.getPassword().equals(password)) {
                // 将用户信息保存在session中
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", user);
                // 跳转至首页
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                // 用户提交信息错误，转发到错误页面
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            // 提交的信息为空
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
