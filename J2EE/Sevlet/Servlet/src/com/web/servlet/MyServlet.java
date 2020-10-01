package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周
 * @title MyServlet
 * @date 2020/6/13 16:48
 * @description Servlet笔记
 * 狭义的Servlet是指Java语言实现的一个接口
 * 广义的Servlet是指任何实现了这个Servlet接口的类
 *
 * Servlet运行于支持Java的应用服务器中。从原理上讲，Servlet可以响应任何类型的请求，大绝大数情况下Servlet只用来扩展基于HTTP协议的Web服务器
 *
 * 特点 运行在Java的应用服务器上
 *     Servlet的实现遵循了服务器能够识别的规则，服务器会自动地根据请求调用对应地Servlet进行请求处理
 *     简单方便，可移植性强
 *
 * 运行流程：
 *      url:http://localhost:8080/servlet/my
 *      组成:服务器地址:端口号/webapps下的文件夹的名称[虚拟项目名]/com.web.servlet.MyServlet[别名]
 *          服务器地址:端口号/虚拟项目名/servlet的别名
 *
 *      URI:虚拟项目名/servlet的别名
 *
 *      浏览器发送请求到服务器，服务器根据请求URL地址中的URI信息在webapps目录下找到对应的项目文件夹，
 *      然后在web.xml中检索响应的Servlet，
 *      找到后调用并执行Servlet
 */
public class MyServlet extends HttpServlet {
    // @Override
    // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     resp.getWriter().write("Hello World.");
    //     System.out.println("Hello World From MyServlet.");
    // }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.getWriter().write("Hello World.");
            System.out.println("Hello World From MyServlet.");
    }

}
