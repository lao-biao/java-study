package com.dao;

import com.pojo.User;

import java.util.List;

/**
 * @author 周
 * @title LoginDao
 * @date 2020/6/14 10:32
 * @description
 */
public interface UserDao {
    /**
     * 根据用户名和密码获取用户信息
     * @param uname
     * @param pwd
     * @return
     */
    User checkUserLoginDao(String uname, String pwd);

    // 根据uid获取用户信息
    User checkUidDao(String uid);

    /**
     * 根据用户id修改用户密码
     * @param newPwd
     * @param uid
     * @return
     */
    int userChangePwdDao(String newPwd, int uid);

    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> userShowDao();

    /**
     * 用户注册
     * @param u
     * @return
     */
    int userRegDao(User u);
}
