package com.spring5.test;

import com.spring5.Book;
import com.spring5.Course;
import com.spring5.Stu;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周
 * @title Test
 * @date 2020/6/20 21:47
 * @description 测试集合类型属性注入
 */
public class CollectionTest {
    @Test
    public void testCollection() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = (Stu) ac.getBean("stu");
        stu.test();
    }

    @Test
    public void testCollection2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = (Book) ac.getBean("book");
        book.test();
    }

    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = ac.getBean("myBean", Course.class);
        System.out.println(course);
    }


}
