package com.spring5.test;

import com.spring5.Book;
import com.spring5.Order;
import com.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周
 * @title TestSpring
 * @date 2020/6/20 17:09
 * @description 测试Spring创建Bean对象
 */
public class TestSpring {
    @Test
    public void testUser() {
        // 1.加载Spring配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");


        // 2.获取配置创建的对象
        User user = ac.getBean("user", User.class);

        System.out.println(user);
        user.add();

        BeanFactory bf = new ClassPathXmlApplicationContext("bean1.xml");
        User u = bf.getBean("user", User.class);
        System.out.println(u);
        u.add();
    }

    @Test
    public void testBook() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = (Book) ac.getBean("book", Book.class);
        book.test();
    }

    @Test
    public void testOrder() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");
        Order order = (Order) ac.getBean("order", Order.class);
        order.test();
    }
}
