package com.study.service;

import com.study.domain.Account;

import java.util.List;

/**
 * @author 周
 * @title AccountService
 * @date 2020/6/30 10:26
 * @description
 */
public interface AccountService {

    void save(Account account);

    List<Account> findAll();
}
