package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 周
 * @title TargetController
 * @date 2020/6/28 17:18
 * @description Controller
 */
@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("unmae", "张三");
        mav.setViewName("index");
        return mav;
    }
}
