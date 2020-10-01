package com.study.mapper;

import com.study.domain.User;

import java.util.List;

/**
 * @author 周
 * @title UserMapper
 * @date 2020/6/29 16:05
 * @description
 */
public interface UserMapper {

    List<User> findAll();


    List<User> findUserRole();

}
