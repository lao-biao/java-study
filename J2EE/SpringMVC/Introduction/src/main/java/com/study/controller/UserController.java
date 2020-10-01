package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周
 * @title UserController
 * @date 2020/6/27 13:57
 * @description Controller
 * 默认查找的目录是webapp目录
 */
@Controller
public class UserController {
    @RequestMapping("/quick")        // 请求映射
    public String quick() {
        System.out.println("UserController.save");
        return "success";  // 相对地址
    }

    /**
     * Model:封装数据
     * View:展示数据
     *
     * @return
     */
    @RequestMapping("/quick2")        // 请求映射
    public ModelAndView quick2() {
        ModelAndView mav = new ModelAndView();
        // 设置模型数据
        mav.addObject("username", "张三");
        // 设置视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/quick3")        // 请求映射
    public ModelAndView quick3(ModelAndView modelAndView) {
        ModelAndView mav = new ModelAndView();
        // 设置模型数据
        mav.addObject("username", "张三");
        // 设置视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/quick4")        // 请求映射
    public String quick4(Model model) {
        model.addAttribute("username", "李四");
        return "success";
    }

    @RequestMapping("/quick5")        // 请求映射
    public void quick5(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setAttribute("username", "王五");
        resp.getWriter().write("Hello World");
    }

    /**
     * 直接回写数据
     *
     * @return
     */
    @RequestMapping("/quick6")        // 请求映射
    @ResponseBody   // 告知SpringMVC框架不进行视图跳转,直接回写数据
    public String quick6() {
        return "Hello World";
    }

    /**
     * 返回json字符串
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/quick7")        // 请求映射
    @ResponseBody   // 告知SpringMVC框架不进行视图跳转,直接回写数据
    public String quick7() throws JsonProcessingException {
        User u = new User("张三", "Female", 22);
        // 使用json转换工具
        ObjectMapper om = new ObjectMapper();

        // 返回json字符串
        return om.writeValueAsString(u);
    }

    /**
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/quick8")        // 请求映射
    @ResponseBody   // 告知SpringMVC框架不进行视图跳转,直接回写数据
    public User quick8() throws JsonProcessingException {
        return new User("张三", "Female", 22);
    }

}
