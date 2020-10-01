package com.study.mapper;

import com.study.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 周
 * @title AccountMapper
 * @date 2020/6/30 10:22
 * @description
 */
public interface AccountMapper {

    @Insert("insert into t_account(uname,money) values(#{uname},#{money});")
    void save(Account account);

    @Select("select * from t_account")
    List<Account> findAll();
}
