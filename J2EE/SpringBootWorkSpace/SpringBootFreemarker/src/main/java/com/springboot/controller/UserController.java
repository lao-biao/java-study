package com.springboot.controller;

import com.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周
 * @title UserController
 * @date 2020/6/26 22:56
 * @description
 */
@Controller
public class UserController {
    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("张三", "男", 20));
        list.add(new User("李四", "男", 22));
        list.add(new User("王五", "男", 18));
        model.addAttribute("list", list);
        return "userlist";
    }
}
