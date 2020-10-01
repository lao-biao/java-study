package com.study.traning.service.impl;

import com.study.traning.dao.UserDao;
import com.study.traning.dao.impl.UserDaoImpl;
import com.study.traning.pojo.UserEntity;
import com.study.traning.service.UserService;

/**
 * @author 周超
 * @title UserServiceImpl
 * @date 2020/7/24 15:50
 * @description
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserEntity checkUser(String username) {
        // 从数据库中查找用户
        UserEntity user = userDao.checkUser(username);
        // 输出user的相关信息
        // System.out.println("用户信息：" + user.toString());
        return user;
    }
}
