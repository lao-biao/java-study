package com.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 周
 * @title TestServlet
 * @date 2020/6/20 11:24
 * @description
 */
@WebServlet(name = "TestServlet",urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        // 处理请求结果
        req.setAttribute("str","监听器学习--request");
        HttpSession hs = req.getSession();
        hs.setAttribute("str","监听器学习--session");
        hs.invalidate();

        ServletContext sc = this.getServletContext();
        sc.setAttribute("str","监听器学习--application");
        // 响应处理结果
        resp.getWriter().write("监听器学习Servlet响应");
    }
}
