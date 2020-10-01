package com.study.springbootweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 整合Listener方式二
 * ServletContextListener 监听上下文
 */
public class SecondListener implements ServletContextListener {
    /**
     * 初始化
     *
     * @param event
     */
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Second Listener--initialized");
    }

    /**
     * 销毁
     *
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event) {

    }
}
