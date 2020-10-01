package com.study.mapper;

import com.study.domain.User;

import java.util.List;

/**
 * @author 周
 * @title UserMapper
 * @date 2020/6/29 13:27
 * @description
 */
public interface UserMapper {
    List<User> findByCondition(User user);

    List<User> findByIds(List<Integer> ids);
}
