package com.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 周
 * @title UserDaoImpl
 * @date 2020/6/21 19:10
 * @description
 */
@Repository(value = "userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("UserDaoImpl.add");
    }
}
