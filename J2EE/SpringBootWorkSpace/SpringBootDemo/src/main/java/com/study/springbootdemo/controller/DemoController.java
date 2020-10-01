package com.study.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理请求 Controller
 */

@RestController // @Controller + @ResponseBody 直接返回字符串（json）
public class DemoController {
    @RequestMapping("/helloWorld")
    public String showHello() {
        return "Hello world";
    }
}
