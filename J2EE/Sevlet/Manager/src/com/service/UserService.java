package com.service;

import com.pojo.User;

import java.util.List;

/**
 * @author 周
 * @title LoginService
 * @date 2020/6/14 10:27
 * @description
 */
public interface UserService {
    /**
     * 校验用户登录信息
     *
     * @param uname
     * @param pwd
     * @return
     */
    User checkLoginService(String uname, String pwd);

    // 校验用户Cookie信息
    User checkLoginService(String uid);

    /**
     * 修改用户密码
     *
     * @param newPwd
     * @param uid
     * @return
     */
    int userChangePwdService(String newPwd, int uid);

    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> userShowService();

    /**
     * 用户注册
     * @param u
     * @return
     */
    int userRegService(User u);
}
