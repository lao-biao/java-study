package com.training.day02;

import java.io.Serializable;

/**
 * @author 周
 * @title MetaHuman
 * @date 2020/7/14 16:30
 * @description MetaHuman类，Human的子类，实现了序列化的接口，并添加run()方法
 */
public class MetaHuman extends Human implements Serializable {
    // 序列化uid
    private static final long serialVersionUID = 7657147428278332925L;

    // 子类的run()方法
    public void run() {
        System.out.println("MetaHuman.run");
    }

}
