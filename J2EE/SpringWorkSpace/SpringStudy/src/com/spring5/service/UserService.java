package com.spring5.service;

import com.spring5.dao.UserDao;
import com.spring5.dao.UserDaoImpl;

/**
 * @author 周
 * @title UserService
 * @date 2020/6/20 20:27
 * @description
 */
public class UserService {

    // 创建UserDao属性，生成set方法
    private UserDao ud;

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    public void addUser(){
        System.out.println("UserService.addUser");
        ud.update();
    }
}
