package com.sping5.handler;

import com.sping5.pojo.User;
import com.sping5.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author 周
 * @title UserHandler
 * @date 2020/6/26 15:55
 * @description 函数式响应编程
 */
public class UserHandler {

    private final UserService us;

    public UserHandler(UserService us) {
        this.us = us;
    }

    // 根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest sr) {
        // 获取id值
        int id = Integer.parseInt(sr.pathVariable("id"));
        // 空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        // 通过Service层查询
        Mono<User> user = this.us.getUserByIdService(id);
        // 转换成流的形式
        // return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user, User.class);
        return user.flatMap(u ->
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(u)))
                .switchIfEmpty(notFound);
    }

    // 查询所有
    public Mono<ServerResponse> getAllUser(ServerRequest sr) {
        Flux<User> users = this.us.getAllUserService();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
    }

    // 添加
    public Mono<ServerResponse> saveUserInfo(ServerRequest sr) {
        // 获取user对象
        Mono<User> userMono = sr.bodyToMono(User.class);
        return ServerResponse.ok().build(this.us.saveUserInfoService(userMono));
    }
}
