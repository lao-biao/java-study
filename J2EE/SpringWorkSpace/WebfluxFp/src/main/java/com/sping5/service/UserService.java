package com.sping5.service;

import com.sping5.pojo.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 周
 * @title UserService
 * @date 2020/6/26 15:13
 * @description 操作接口
 */
public interface UserService {
    // 根据id查找用户
    Mono<User> getUserByIdService(int id);

    // 查询所有用户
    Flux<User> getAllUserService();

    // 添加用户
    Mono<Void> saveUserInfoService(Mono<User> userMono);
}
