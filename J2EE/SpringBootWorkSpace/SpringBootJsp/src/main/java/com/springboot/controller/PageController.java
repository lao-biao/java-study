package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 周
 * @title PageController
 * @date 2020/6/26 21:05
 * @description 页面跳转Controller
 */
@Controller
public class PageController {
    // 页面跳转
    @GetMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
