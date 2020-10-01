package com.sping5;

import com.sping5.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


/**
 * @author 周
 * @title Client
 * @date 2020/6/26 16:38
 * @description 使用WebClient进行调用
 */
public class Client {
    public static void main(String[] args) {
        // 调用服务器地址，端口号自定义
        WebClient wc = WebClient.create("http://127.0.0.1:62380");

        // 根据id查询
        String id = "1";
        User user = wc.get()
                .uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        System.out.println(user);

        // 查询所有
        Flux<User> users = wc.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class);
        users.map(u -> u).buffer().doOnNext(System.out::println).blockFirst();
    }
}
