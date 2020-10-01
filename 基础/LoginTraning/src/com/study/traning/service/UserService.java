package com.study.traning.service;

import com.study.traning.pojo.UserEntity;

/**
 * @author 周超
 * @title UserService
 * @date 2020/7/24 15:50
 * @description
 */
public interface UserService {

    // 通过用户名
    UserEntity checkUser(String username);
}
