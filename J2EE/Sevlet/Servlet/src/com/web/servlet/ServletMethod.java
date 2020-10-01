package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周
 * @title ServletMethod
 * @date 2020/6/13 21:34
 * @description Servlet方法笔记
 *
 * service() 可以处理get/post方式的请求，如果Servlet中有service方法会优先调用service方法对请求进行处理
 *
 * doGet()  处理get方式请求
 *
 * doPost() 处理post方式请求
 *
 * 注意:如果在覆写的service方法中又调用了父类的service方法
 *     则service方法处理完成后，会再次根据请求方式响应的doGet和doPost方法执行。所以，
 *     一般情况下不在覆写的service方法中调用父类的service方法，避免出现405错误
 *
 * Servlet的常见错误
 *      404错误:资源未找到
 *          原因1:在请求地址中的servlet的别名书写错误
 *          原因2:虚拟项目名称拼写错误
 *      500错误:内容服务器错误
 *          java.lang.ClassNotFoundException
 *          解决:在web.xml中校验Servlet类的全限定路径是否拼写错误
 *
 *          逻辑错误:因为service方法的代码执行错误导致，根据错误提示对service方法体中的代码进行错误更改
 *      405错误:请求方式不支持
 *          原因:请求方式和Servlet中的方法不匹配所造成
 *          解决:尽量使用service方法进行请求处理，并且不要再service方法中调用父类的service
 */
public class ServletMethod extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletMethod.service");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletMethod.doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletMethod.doPost");
    }
}
