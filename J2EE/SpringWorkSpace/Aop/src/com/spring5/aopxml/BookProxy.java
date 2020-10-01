package com.spring5.aopxml;

import org.springframework.stereotype.Component;

/**
 * @author 周
 * @title BookProxy
 * @date 2020/6/25 14:07
 * @description
 */

public class BookProxy {
    public void before(){
        System.out.println("BookProxy.before");
    }
}
