package com.service;

import com.pojo.User;

/**
 * @author 周
 * @title LoginService
 * @date 2020/6/14 10:27
 * @description
 */
public interface LoginService {
    // 校验用户登录信息
    User checkLoginService(String uname, String pwd);
    // 校验用户Cookie信息
    User checkLoginService(String uid);
}
