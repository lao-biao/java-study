package com.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 周
 * @title Use人DaoImpl
 * @date 2020/6/25 22:08
 * @description UserDao实现类
 * 实现Tom给Jack转账100元
 */
@Repository
public class Use人DaoImpl implements UserDao {
    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jt;

    @Override
    public void addMoney() {
        String sql = "update t_account set money=money+? where uname=?";
        jt.update(sql, 100, "Jack");
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money-? where uname=?";
        jt.update(sql, 100, "Tom");
    }
}
