package com.web.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 周
 * @title MyListener
 * @date 2020/6/20 13:04
 * @description Listener学习
 * 作用:
 *  监听作用域对象request、session、application的创建、销毁和内容的改变
 * 使用:
 *  创建一个实现了指定接口的java类
 *      监听request-->ServletRequestListener  监听request对象的创建和销毁
 *          requestInitialized(ServletRequestEvent sre) 创建
 *          requestDestroyed(ServletRequestEvent sre)   销毁
 *          注意:形参获取监听的request对象
 *              sre.getServletRequest()
 *
 *      监听request-->ServletRequestAttributeListener 监听request作用域数据的增加、修改、删除
 *          attributeAdded(ServletRequestAttributeEvent srae)
 *          attributeReplaced(ServletRequestAttributeEvent srae)
 *          attributeRemoved(ServletRequestAttributeEvent srae)
 *          注意:形参可以获取被监听的数据
 *              srae.getName()  获取监听数据的键名
 *              srae.getValue()  获取监听数据的值
 *
 *      监听session-->HttpSessionListener 监听session的创建和销毁
 *          sessionCreated(HttpSessionEvent se)
 *          sessionDestroyed(HttpSessionEvent se)
 *          注意:形参可以获取被监听的session对象
 *              se.getSession();
 *
 *      监听session-->HttpSessionAttributeListener 监听session数据的创建和销毁
 *          attributeAdded(HttpSessionBindingEvent se)
 *          attributeReplaced(HttpSessionBindingEvent se)
 *          attributeRemoved(HttpSessionBindingEvent se)
 *          注意:形参可以获取被监听的数据
 *              se.getName()    获取数据的键名
 *              se.getValue()   获取数据的值
 *
 *      监听application-->ServletContextListener  监听application对象的初始化和销毁
 *          contextInitialized(ServletContextEvent sce) 初始化 服务器启动
 *          contextDestroyed(ServletContextEvent sce)   销毁  服务器关闭
 *          注意:形参可以获取当前application对象
 *              sce.getApplication()
 *
 *     监听application-->ServletContextAttributeListener
 *          attributeAdded(ServletContextAttributeEvent scae)
 *          attributeReplaced(ServletContextAttributeEvent scae)
 *          attributeRemoved(ServletContextAttributeEvent scae)
 *          注意:形参可以获取被监听的数据
 *              scae.getName()  获取数据的键名
 *              scae.getValue() 获取数据的值
 *
 *  在web.xml中配置监听类
 *     <listener>
 *         <listener-class>com.web.listener.MyListener</listener-class>
 *     </listener>
 * 		@WebListener(value = "/test")
 *     可配置多个
 *  案例
 *      统计当前在线人数
 *      设计网页浏览器次数
 *
 */
@WebListener(value = "/test")
public class MyListener implements ServletRequestListener , ServletRequestAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener,
        ServletContextListener,ServletContextAttributeListener {

    // request对象的创建
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // sre.getServletContext();
        System.out.println("MyListener.requestInitialized");
    }

    // request对象的销毁
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyListener.requestDestroyed");
    }

    // request对象作用域数据的增加
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("request中增加了一条数据"+srae.getName()+"=>"+srae.getValue());

    }

    // request对象作用域数据的修改
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }

    // request对象作用域数据的删除
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }

    /*------------------------------------------------------------*/

    // session对象创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("MyListener.sessionCreated");
    }

    // session对象的销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("MyListener.sessionDestroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("MyListener.attributeAdded"+se.getName()+"=>"+se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("MyListener.attributeAdded"+se.getName()+"=>"+se.getValue());
    }

    /*------------------------------------------------------------*/

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyListener.contextInitialized"+sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener.contextDestroyed"+sce.getServletContext());
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("MyListener.attributeAdded"+scae.getName()+"=>"+scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {

    }
}
