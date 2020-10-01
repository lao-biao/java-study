package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;

/**
 * @author 周
 * @title UserServiceImpl
 * @date 2020/6/18 16:29
 * @description
 */
public class UserServiceImpl implements UserService {
    // 获取dao层对象
    private UserDao ud=new UserDaoImpl();
    @Override
    public User getUserInfoService(String name) {
        return ud.getUserInfoDao(name);
    }
}
