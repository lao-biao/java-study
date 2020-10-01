package com.spring5;

/**
 * @author 周
 * @title Book
 * @date 2020/6/20 18:17
 * @description 通过set方法注入属性
 */
public class Book {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void test() {
        System.out.println(this.name);
    }
}
