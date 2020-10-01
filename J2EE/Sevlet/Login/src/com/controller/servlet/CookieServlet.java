package com.controller.servlet;

import com.pojo.User;
import com.service.LoginService;
import com.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie 信息校验
 *  判断请求中是否携带正确的Cookie信息
 *  如果有则校验Cookie信息是否正确
 *      如果校验正确则直接响应主页面给用户
 *      如果校验不正确则响应登录页面给用户
 *  没有则请求转发给登录页面
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        // 获取Cookie信息
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            // 遍历Cookie信息
            String uid = "";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uid")) {
                    uid = cookie.getValue();
                }
            }
            if ("".equals(uid)) {
                req.getRequestDispatcher("page").forward(req, resp);
                return;
            } else {
                // 校验uid用户信息
                // 获取业务层对象
                LoginService ls = new LoginServiceImpl();
                User user = ls.checkLoginService(uid);
                if (user != null) {
                    // 将用户数据存储到session对象中
                    req.getSession().setAttribute("user", user);

                    // 网页计数器自增
                    int num = (int) this.getServletContext().getAttribute("number");
                    this.getServletContext().setAttribute("number", ++num);

                    // 重定向
                    resp.sendRedirect("/login/main");
                    return;
                } else {
                    // 请求转发
                    req.getRequestDispatcher("page").forward(req, resp);
                    return;
                }
            }
        } else {
            // 请求转发
            req.getRequestDispatcher("page").forward(req, resp);
            return;
        }
    }
}
