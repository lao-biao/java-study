package com.service.impl;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;
import com.pojo.User;
import com.service.LoginService;

/**
 * @author 周
 * @title LoginServiceImpl
 * @date 2020/6/14 10:29
 * @description
 */
public class LoginServiceImpl implements LoginService {
    // 创建Dao层过度向
    LoginDao ld=new LoginDaoImpl();
    @Override
    public User checkLoginService(String uname, String pwd) {
        return ld.checkUserLoginDao(uname,pwd);
    }

    @Override
    public User checkLoginService(String uid) {
        return ld.checkUidDao(uid);
    }
}
