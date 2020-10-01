package com.study.service;

import com.study.exception.MyException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author 周
 * @title DemoServiceImpl
 * @date 2020/6/28 19:59
 * @description Service实现类，抛出各种异常
 */
@Service
public class DemoServiceImpl implements DemoService {
    public void show1() {
        System.out.println("类型转换异常");
        Object str = "HaHa";
        Integer integer = (Integer) str;
    }

    public void show2() {
        System.out.println("除以0的异常");
        int res = 1 / 0;
    }

    public void show3() throws FileNotFoundException {
        System.out.println("文件找不到异常");
        InputStream is = new FileInputStream("C:/xxxx/xxx.txt");
    }

    public void show4() {
        System.out.println("空指针异常");
        String s = null;
        s.length();
    }

    public void show5() throws MyException {
        System.out.println("自定义异常");
        throw new MyException();
    }

}
