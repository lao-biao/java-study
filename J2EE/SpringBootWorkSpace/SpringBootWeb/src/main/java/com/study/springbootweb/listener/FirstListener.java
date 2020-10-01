package com.study.springbootweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 整合Listener方式一
 * ServletContextListener 监听上下文
 */
@WebListener
public class FirstListener implements ServletContextListener {
    /**
     * 初始化
     *
     * @param event
     */
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("First Listener--initialized");
    }

    /**
     * 销毁
     *
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event) {

    }
}
