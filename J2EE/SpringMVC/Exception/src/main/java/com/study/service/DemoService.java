package com.study.service;

import com.study.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @author 周
 * @title DemoService
 * @date 2020/6/28 19:59
 * @description Service接口
 */
public interface DemoService {
    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;

}
