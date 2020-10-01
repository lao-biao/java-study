package com.controller.servlet;

import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 周
 * @title ShowServlet
 * @date 2020/6/14 20:12
 * @description 显示用户信息
 */
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取请求信息
        HttpSession hs = req.getSession();
        User user = (User) hs.getAttribute("user");
        // 处理请求信息

        // 响应处理结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<table border='1px'>");
        resp.getWriter().write("<tr>");
        resp.getWriter().write("<td>用户名</td>");
        resp.getWriter().write("<td>" + user.getUname() + "</td>");
        resp.getWriter().write("</tr>");
        resp.getWriter().write("<tr>");
        resp.getWriter().write("<td>密码</td>");
        resp.getWriter().write("<td>" + user.getPwd() + "</td>");
        resp.getWriter().write("</tr>");
        resp.getWriter().write("</table>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
