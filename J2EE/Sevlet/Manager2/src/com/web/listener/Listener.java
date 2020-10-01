package com.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 问题，由于B/S架构不能对浏览器页面的关闭进行监听，用户通过关闭页面时，服务器没有清除session，用户在线人数不会-1
 * 使用C/S架构解决
 * 用户在线人数是静态的，只有刷新后才能更新显示
 */
@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // session被创建时人数自增
    public void sessionCreated(HttpSessionEvent se) {
        // 获取ServletContext对象
        ServletContext sc = se.getSession().getServletContext();
        // 获取在线统计人数的变量
        int count = (int) sc.getAttribute("online");
        sc.setAttribute("online", ++count);
    }

    // session被销毁时人数自减
    public void sessionDestroyed(HttpSessionEvent se) {
        // 获取ServletContext对象
        ServletContext sc = se.getSession().getServletContext();
        // 获取在线统计人数的变量
        int count = (int) sc.getAttribute("online");
        sc.setAttribute("online", --count);
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取application
        ServletContext sc = sce.getServletContext();
        // 在application对象存储变量用来统计在线人数
        sc.setAttribute("online", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
