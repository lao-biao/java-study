package com.study.controller;

import com.study.pojo.User;
import com.study.pojo.ViewObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 周
 * @title ParamController
 * @date 2020/6/28 11:09
 * @description 获取请求参数类型
 */
@Controller
public class ParamController {
    /**
     * 获取普通类型参数
     * http://localhost:8080/param?uname=张三&age=20
     *
     * @param uname
     * @param age
     */
    @RequestMapping("/param")
    @ResponseBody
    public void param(String uname, int age) {
        System.out.println("ParamController.param");
        System.out.println(uname + ":" + age);
    }

    /**
     * 获取pojo类型参数
     * http://localhost:8080/parampojo?uname=张三&age=20&gender=Male
     * 输出[Hello, World]
     *
     * @param user
     */
    @RequestMapping("/parampojo")
    @ResponseBody
    public void paramPojo(User user) {
        System.out.println("ParamController.paramPojo");
        System.out.println(user.getUname() + ":" + user.getGender() + ":" + user.getAge());
    }

    /**
     * 获取数组类型参数
     * http://localhost:8080/paramarray?arr=Hello&arr=World
     *
     * @param arr
     */
    @RequestMapping("/paramarray")
    @ResponseBody
    public void paramArray(String[] arr) {
        System.out.println("ParamController.paramArray");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 获取集合类型参数
     * http://localhost:8080/jsp/form.jsp
     *
     * @param vo POJO包装类
     */
    @RequestMapping(value = "/paramset", method = RequestMethod.POST)
    @ResponseBody
    public void paramSet(ViewObject vo) {
        System.out.println("ParamController.paramSet");
        System.out.println(vo);
    }

    /**
     * Ajax方式获取集合类型参数
     *
     * @param userList
     */
    @RequestMapping(value = "/paramajax", method = RequestMethod.POST)
    @ResponseBody
    public void paramAjax(@RequestBody List<User> userList) {
        System.out.println("ParamController.paramAjax");
        System.out.println(userList);
    }

    /**
     * 自定义日期类型参数转换
     *
     * @param date
     */
    @RequestMapping(value = "/param/{date}")
    @ResponseBody
    public void paramDate(@PathVariable(value = "date") Date date) {
        System.out.println(date);
    }

    /**
     * 获取头部信息
     *
     * @param userAgent
     */
    @RequestMapping(value = "/paramheader")
    @ResponseBody
    public void paramHeader(@RequestHeader(value = "User-Agent") String userAgent) {
        System.out.println(userAgent);
    }

    /**
     * 获取cookie信息
     *
     * @param jsessionid
     */
    @RequestMapping(value = "/paramcookie")
    @ResponseBody
    public void paramCookie(@CookieValue(value = "JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
    }

    /**
     * 单文件上传
     *
     * @param uname
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public void uploadFile(String uname, MultipartFile file) throws IOException {
        System.out.println("ParamController.upload");
        // 获取文件名称
        String filename = file.getOriginalFilename();
        System.out.println(uname + "上传了" + filename);
        // 存储
        file.transferTo(new File("D:/upload/" + filename));
    }

    /**
     * 多文件上传
     *
     * @param uname
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "/upload-multiply")
    @ResponseBody
    public void uploadMultiplyFile(String uname, MultipartFile[] file) throws IOException {
        System.out.println("ParamController.upload");
        for (MultipartFile multipartFile : file) {
            // 获取文件名称
            String filename = multipartFile.getOriginalFilename();
            System.out.println(uname + "上传了" + filename);
            // 存储
            multipartFile.transferTo(new File("D:/upload/" + filename));
        }
    }
}
