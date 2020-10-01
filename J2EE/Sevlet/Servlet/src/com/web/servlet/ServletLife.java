package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet生命周期
 *  1.从第一次调用到服务器关闭
 *  2.如果Servlet在web.xml中配置了load-on-startup，生命周期为从服务器启动到服务器关闭
 *
 * init方法是对Servlet进行初始化的方法，会在Servlet第一次加载进行存储时执行
 * destroy方法是在Servlet被销毁时执行，即服务器关闭时
 */
public class ServletLife extends HttpServlet {


    // init()方法，在servlet第一次加载内存的时候被调用
    @Override
    public void init() throws ServletException {
        System.out.println("servlet 初始化完成");
    }

    // service()方法，真正处理请求时调用
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet life");
    }

    // 服务器被关闭时调用
    @Override
    public void destroy() {
        System.out.println("servlet 被销毁");
    }
}
