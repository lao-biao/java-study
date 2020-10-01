package com.training.day01;

/**
 * @author 周超
 * @title Homework2
 * @date 2020/7/13 18:52
 * @description 输出99乘法表
 */
public class Homework2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                // 对齐
                System.out.print(i + "*" + j + "=" + (i * j) + (i * j < 10 ? "   " : "  "));
            }
            System.out.println(""); // 换行
        }
    }
}
