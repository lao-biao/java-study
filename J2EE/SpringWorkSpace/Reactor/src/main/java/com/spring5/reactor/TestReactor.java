package com.spring5.reactor;

import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 周
 * @title TestReactor
 * @date 2020/6/26 13:03
 * @description
 */
public class TestReactor {
    public static void main(String[] args) {
        // just方法之间声明
        Flux.just(1, 2, 3, 4).subscribe(System.out::print);
        Mono.just(1);
        /*
        // 其他方法
        Integer[] arr = {1, 2, 3, 4};
        Flux.fromArray(arr);

        List<Integer> list = Arrays.asList(arr);
        Flux.fromIterable(list);

        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);
         */

    }
}
