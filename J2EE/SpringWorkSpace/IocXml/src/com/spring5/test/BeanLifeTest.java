package com.spring5.test;

import com.spring5.autowire.Emp;
import com.spring5.life.Order;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周
 * @title BeanLifeTest
 * @date 2020/6/21 15:46
 * @description
 */
public class BeanLifeTest {
    @Test
    public void testLife() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean4.xml");
        Order order = ac.getBean("order", Order.class);
        System.out.println(order);
        ac.close();

    }

    @Test
    public void testAutoWire() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = ac.getBean("emp", Emp.class);
        System.out.println(emp);

    }
}
