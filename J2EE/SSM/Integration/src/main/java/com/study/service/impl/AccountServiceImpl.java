package com.study.service.impl;

import com.study.domain.Account;
import com.study.mapper.AccountMapper;
import com.study.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周
 * @title AccountServiceImpl
 * @date 2020/6/30 10:27
 * @description
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper am;

    @Override
    public void save(Account account) {
        am.save(account);
        logger.debug("执行保存操作");
    }

    @Override
    public List<Account> findAll() {
        List<Account> accountList = am.findAll();
        logger.debug(accountList);
        return accountList;
    }
}
