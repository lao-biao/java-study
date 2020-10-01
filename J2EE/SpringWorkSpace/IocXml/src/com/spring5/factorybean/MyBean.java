package com.spring5.factorybean;

import com.spring5.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 周
 * @title MyBean
 * @date 2020/6/21 15:10
 * @description
 */
public class MyBean implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("Spring5");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
