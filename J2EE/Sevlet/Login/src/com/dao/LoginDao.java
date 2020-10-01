package com.dao;

import com.pojo.User;

/**
 * @author 周
 * @title LoginDao
 * @date 2020/6/14 10:32
 * @description
 */
public interface LoginDao {
    // 根据用户名和密码获取用户信息
    User checkUserLoginDao(String uname,String pwd);
    // 根据uid获取用户信息
    User checkUidDao(String uid);
}
