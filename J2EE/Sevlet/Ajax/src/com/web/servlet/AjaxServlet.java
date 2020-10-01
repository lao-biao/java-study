package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ajax请求处理
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/ajax"})
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        //  获取请求信息
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name + "<===>" + pwd);
        System.out.println(req.getMethod());
        // 处理请求信息
        // 响应处理结果
        resp.getWriter().write("今天天气很好");
    }
}
