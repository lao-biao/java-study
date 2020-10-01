package com.spring5.test;

import com.spring5.config.SpringConfig;
import com.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周
 * @title SpringTest
 * @date 2020/6/20 21:47
 * @description 测试
 */
public class SpringTest {

    @Test
    public void testService() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");
        UserService us = ac.getBean("userService", UserService.class);
        us.add();
    }

    @Test
    public void testService2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService us = ac.getBean("userService", UserService.class);
        us.add();
    }

}
