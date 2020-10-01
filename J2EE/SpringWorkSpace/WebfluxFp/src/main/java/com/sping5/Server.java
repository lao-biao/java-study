package com.sping5;

import com.sping5.handler.UserHandler;
import com.sping5.service.UserService;
import com.sping5.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @author 周
 * @title Server
 * @date 2020/6/26 16:19
 * @description 服务器创建和路由创建以及关联handler
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    // 创建Router
    public RouterFunction<ServerResponse> routerFunction() {
        UserService us = new UserServiceImpl();
        UserHandler uh = new UserHandler(us);
        return RouterFunctions.route(
                GET("/user/{id}").and(accept(APPLICATION_JSON)), uh::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), uh::getAllUser);
    }

    // 创建服务器完成适配
    public void createReactorServer() {
        // 路由和Handler适配
        RouterFunction<ServerResponse> router = routerFunction();
        HttpHandler hh = toHttpHandler(router);
        ReactorHttpHandlerAdapter rhha = new ReactorHttpHandlerAdapter(hh);
        // 创建服务器
        HttpServer hs = HttpServer.create();
        hs.handle(rhha).bindNow();
    }
}
