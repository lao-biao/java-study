package com.sping5.controller;

import com.sping5.pojo.User;
import com.sping5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 周
 * @title UserController
 * @date 2020/6/26 15:27
 * @description
 */
@RestController
public class UserController {
    // 注入service
    @Autowired
    private UserService us;

    // id查询
    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return us.getUserByIdService(id);
    }

    // 查询所有
    @GetMapping("/user")
    public Flux<User> getAllUser() {
        return us.getAllUserService();
    }

    // 添加
    @GetMapping("/user/save")
    public Mono<Void> saveUserInfo(@RequestBody User user) {
        Mono<User> um = Mono.just(user);
        return us.saveUserInfoService(um);
    }
}
