package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * request对象学习
 * 作用:request对象中封存了当前的所有请求信息
 * 使用:
 * * 获取请求头数据
 *      req.getMethod()              获取请求方式
 *      req.getRequestURL()          获取请求URL信息
 *      req.getRequestURI()          获取请求URI信息
 *      req.getScheme()              获取协议
 * * 获取请求行数据
 *      req.getHeader("键名")          返回指定的请求头信息
 *      req.getHeaderNames()          返回请求头的键名的枚举集合
 * * 获取用户数据
 *      req.getParameter("键名")        返回指定的用户数据
 *      req.getParameterValues("键名")    返回同键不同值的请求数据
 *      req.getParameterNames()          返回所有用户请求数据的枚举集合
 *
 * 如果要获取的请求数据不存在，不会报错，返回null
 * 注意:request对象由tomcat服务器创建，并作为实参传递给处理请求的Servlet的service方法
 */
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求头数据
        String method = req.getMethod();    // 获取请求方式
        StringBuffer requestURL = req.getRequestURL();// 获取请求URL
        String requestURI = req.getRequestURI();
        String scheme = req.getScheme();    // 获取请求协议
        System.out.println("method==>" + method + "  URL==>" + requestURL + "  URI==>" + requestURI + "  scheme==>" + scheme);

        // 获取行数据
        String header = req.getHeader("User-Agent");    // 获取指定的请求行信息
        System.out.println(header);
        Enumeration<String> headerNames = req.getHeaderNames(); // 获取所有请求行的枚举
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + "==>" + value);
        }

        // 获取用户数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println("uname==>" + uname + "  pwd==>" + pwd);

        String[] favs = req.getParameterValues("fav");
        for (String fav : favs) {
            System.out.println(fav);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
