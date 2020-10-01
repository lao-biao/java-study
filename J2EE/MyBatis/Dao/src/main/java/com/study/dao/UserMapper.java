package com.study.dao;

import com.study.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author 周
 * @title UserMapper
 * @date 2020/6/29 12:41
 * @description UserDao接口
 */
public interface UserMapper {
    // 查询所有
    List<User> findAll() throws IOException;

    User findById(int uid);
}
