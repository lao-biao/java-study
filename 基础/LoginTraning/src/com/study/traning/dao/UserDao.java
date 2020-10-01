package com.study.traning.dao;

import com.study.traning.pojo.UserEntity;

/**
 * @author 周超
 * @title UserDao
 * @date 2020/7/24 15:51
 * @description
 */
public interface UserDao {
    // 检查用户登录信息
    UserEntity checkUser(String username);
}
