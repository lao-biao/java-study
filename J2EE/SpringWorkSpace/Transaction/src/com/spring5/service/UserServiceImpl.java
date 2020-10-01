package com.spring5.service;

import com.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 周
 * @title UserServiceImpl
 * @date 2020/6/25 22:07
 * @description UserService实现类
 */
@Service
@Transactional(transactionManager = "transactionManager")
public class UserServiceImpl implements UserService {
    // 注入UserDao
    @Autowired
    private UserDao ud;

    @Override
    public void accountMoney() {
        ud.reduceMoney();
        // 模拟异常
        int res = 10 / 0;
        ud.addMoney();
    }
}
