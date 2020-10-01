package com.study.mapper;

import com.study.domain.User;

import java.util.List;

/**
 * @author 周
 * @title UserMapper
 * @date 2020/6/29 14:38
 * @description UserMapper接口，Dao层相应操作
 */
public interface UserMapper {
    void save(User user);

    User findById(int uid);

    List<User> findAll();
}
