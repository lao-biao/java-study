package com.spring5;

/**
 * @author 周
 * @title Course
 * @date 2020/6/20 21:41
 * @description
 */
public class Course {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
