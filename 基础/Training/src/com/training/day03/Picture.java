package com.training.day03;

import java.io.*;

/**
 * @author 周超
 * @title Picture
 * @date 2020/7/15 15:55
 * @description 文件读写
 * try-with-resource
 * 编译环境：java 1.8
 */
public class Picture {

    public static void main(String[] args) {
        // try-with-resource，FileInputStream，FileOutputStream间接继承了AutoCloseable，自动关流
        try (FileInputStream fis = new FileInputStream(new File("D:\\picture\\SpringFramework.png"));
             FileOutputStream fos = new FileOutputStream(new File("D:\\temp\\temp.png"))) {
            byte[] buffer = new byte[1024];
            int len;
            // 读文件
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);  // 写文件
            }
            fos.flush();
        } catch (IOException e) {
            // 异常处理
            e.printStackTrace();
        }
    }

    /**
     * 传统方式
     */
    public static void tryCatchFinally() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("D:\\picture\\SpringFramework.png"));
            fos = new FileOutputStream(new File("D:\\temp\\temp.png"));
            byte[] buffer = new byte[1024];     // 缓冲流
            int len;
            // 读文件
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);  // 写文件
            }
            fos.flush();
        } catch (IOException e) {
            // 异常处理
            e.printStackTrace();
        } finally {
            // 关流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
