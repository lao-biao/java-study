package com.spring5.test;

import com.spring5.config.TxConfig;
import com.spring5.pojo.User;
import com.spring5.service.UserService;
import com.spring5.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author 周
 * @title Client
 * @date 2020/6/25 22:01
 * @description 测试类
 * org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'userServiceImpl' is expected to be of type 'com.spring5.service.UserServiceImpl' but was actually of type 'com.sun.proxy.$Proxy18'
 * 解决： <tx:annotation-driven transaction-manager="transactionManager" proxy-target-class="true"/>
 */
public class Client {
    @Test
    public void testAccountAnno() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("transaction.xml");
        UserService us = ac.getBean("userServiceImpl", UserServiceImpl.class);
        us.accountMoney();
    }

    @Test
    public void testAccountXml() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("txxml.xml");
        UserService us = ac.getBean("userServiceImpl", UserServiceImpl.class);
        us.accountMoney();
    }
    @Test
    public void testAccountConfig(){
        ApplicationContext as=new AnnotationConfigApplicationContext(TxConfig.class);
        UserService us=as.getBean("userServiceImpl",UserServiceImpl.class);
        us.accountMoney();
    }
    @Test
    public void testGeneric(){
        GenericApplicationContext gac=new GenericApplicationContext();
        gac.refresh();
        // gac.registerBean(User.class, User::new);
        // User user = gac.getBean("com.spring5.pojo.User", User.class);
        gac.registerBean("user",User.class, User::new);
        User user = gac.getBean("user", User.class);
        System.out.println(user);

    }
}
