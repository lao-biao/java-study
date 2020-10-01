package com.spring5.test;

import com.spring5.aop.User;
import com.spring5.aopxml.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周
 * @title AopTest
 * @date 2020/6/21 22:15
 * @description 测试AspectJ生成动态代理
 */
public class AopTest {
    @Test
    public void testAop() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        User user = ac.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAopXml() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aopxml.xml");
        Book book = ac.getBean("book", Book.class);
        book.buy();
    }
}
