package com.sping5.service.impl;

import com.sping5.pojo.User;
import com.sping5.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 周
 * @title UserServiceImpl
 * @date 2020/6/26 15:16
 * @description Service接口实现类
 */
@Repository
public class UserServiceImpl implements UserService {

    // 模拟数据
    private final Map<Integer, User> userMap = new HashMap<>();

    public UserServiceImpl() {
        this.userMap.put(1, new User("Tom", "Male", 20));
        this.userMap.put(2, new User("Jack", "Male", 22));
        this.userMap.put(3, new User("Marry", "Female", 18));
    }

    @Override
    public Mono<User> getUserByIdService(int id) {
        return Mono.just(userMap.get(id));
    }

    @Override
    public Flux<User> getAllUserService() {
        return Flux.fromIterable(this.userMap.values());
    }

    @Override
    public Mono<Void> saveUserInfoService(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            // 向map里存值
            int id = userMap.size() + 1;
            userMap.put(id, user);
        }).thenEmpty(Mono.empty()); // 空值信号
    }
}
