package com.controller.servlet;

import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周
 * @title MainServlet
 * @date 2020/6/14 13:37
 * @description 主页面(欢迎页面)
 */
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        // 获取session中的数据
        User user = (User) req.getSession().getAttribute("user");
        // 获取网页浏览次数
        int num= (int) this.getServletContext().getAttribute("number");

        // 处理请求信息

        // 响应处理结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎"+user.getUname()+"登录本系统</h3>");
        resp.getWriter().write("当前网页浏览次数为:"+num);
        resp.getWriter().write("<hr>");
        resp.getWriter().write("<form action='show' method='get'>");
        resp.getWriter().write("<input type='submit' value='查看个人信息'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
