package com.training.day01;

/**
 * @author 周超
 * @title Homework1
 * @date 2020/7/13 18:40
 * @description 输出金字塔
 */
public class Homework1 {
    public static void main(String[] args) {
        int floor = 5;  // 层数
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < floor - i - 1; j++) {
                System.out.print(" ");  // 空格
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");     // 换行
        }
    }
}
