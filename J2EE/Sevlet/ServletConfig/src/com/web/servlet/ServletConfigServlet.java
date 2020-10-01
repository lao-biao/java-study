package com.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周
 * @title ServletConfigServlet
 * @date 2020/6/15 15:47
 * @description ServletConfig对象笔记
 * 解决在web.xml中给每个Servlet单独配置的数据
 * 使用:
 *      获取ServletConfig对象
 *      获取web.xml中的配置数据
 *
 */
public class ServletConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取ServletConfig对象
        ServletConfig sc = this.getServletConfig();

        // 获取web.xml中的配置
        String config = sc.getInitParameter("config");
        System.out.println(config);
    }
}
