package com.study.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {
    @RequestMapping("/index")
    public String showIndexPage() {
        return "index.html";
    }
}
