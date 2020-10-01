package com.spring5.aop;

import org.springframework.stereotype.Component;

/**
 * @author 周
 * @title User
 * @date 2020/6/21 22:00
 * @description 被增强类
 */
@Component
public class User {
    public void add() {
        System.out.println("User.add");
    }
}
