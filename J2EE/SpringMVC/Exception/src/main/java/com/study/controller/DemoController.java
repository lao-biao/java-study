package com.study.controller;

import com.study.exception.MyException;
import com.study.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 周
 * @title DemoController
 * @date 2020/6/28 19:58
 * @description
 */
@Controller
public class DemoController {

    @Autowired
    private DemoService ds;

    @RequestMapping("/show")
    public String show() throws MyException {
        ds.show1();
        // ds.show5();
        System.out.println("DemoController.show");
        return "index";
    }

}
