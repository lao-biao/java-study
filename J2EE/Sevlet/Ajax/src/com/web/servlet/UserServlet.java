package com.web.servlet;

import com.google.gson.Gson;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        String name=req.getParameter("name");
        System.out.println(name);
        // 处理请求信息
        // 获取业务层请求
        UserService us=new UserServiceImpl();
        User u = us.getUserInfoService(name);
        System.out.println(u);
        Gson gson=new Gson();
        // 响应处理结果
        // resp.getWriter().write("var obj={};obj.name='"+u.getUname()+ "';");
        resp.getWriter().write(gson.toJson(u, User.class));
    }
}
