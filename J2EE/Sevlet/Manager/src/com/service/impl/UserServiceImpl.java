package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author 周
 * @title LoginServiceImpl
 * @date 2020/6/14 10:29
 * @description
 */
public class UserServiceImpl implements UserService {
    // 声明日志对象
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    // 创建Dao层过度向
    UserDao ud = new UserDaoImpl();

    @Override
    public User checkLoginService(String uname, String pwd) {
        // 打印日志
        logger.debug(uname+"发起登录请求");
        User u = ud.checkUserLoginDao(uname, pwd);
        // 判断
        if (u!=null) {
            logger.debug(uname+"登录成功");
        }else {
            logger.debug(uname+"登录失败");
        }
        return u;
    }

    @Override
    public User checkLoginService(String uid) {
        return ud.checkUidDao(uid);
    }

    // 修改用户密码
    @Override
    public int userChangePwdService(String newPwd, int uid) {
        logger.debug(uid+"发起密码修改请求");
        int index = ud.userChangePwdDao(newPwd,uid);
        // 判断
        if (index!=-1) {
            logger.debug(uid+"密码修改成功");
        }else {
            logger.debug(uid+"密码修改失败");
        }
        return index;
    }

    // 获取所有的用户信息
    @Override
    public List<User> userShowService() {
        List<User> lu = ud.userShowDao();
        // 显示所有用户信息
        logger.debug("显示所有用户信息"+lu);
        return lu;
    }

    // 用户注册
    @Override
    public int userRegService(User u) {
        int index = ud.userRegDao(u);
        // 判断
        if (index != -1) {
            logger.debug( "用户注册成功");
        } else {
            logger.debug("用户注册失败");
        }
        return index;
    }
}
