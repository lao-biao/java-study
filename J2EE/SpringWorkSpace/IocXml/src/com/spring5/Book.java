package com.spring5;

import java.util.List;

/**
 * @author 周
 * @title Book
 * @date 2020/6/20 22:11
 * @description
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test() {
        System.out.println(list.toString());
    }
}
