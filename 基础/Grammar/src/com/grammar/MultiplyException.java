package com.grammar;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 多异常并列
 */
public class MultiplyException {
    public static void main(String[] args) {
/*
        try {
            test();     //操作
        } catch (IOException | SQLException ie) {
            ie.printStackTrace();
        }
*/

        int a = 0b0011_1011_0001;//二进制

        int b = 02_014;//八进制

        int c = 123__456;//十进制，可使用多个下划线

        int d = 0x7_B_1;//十六进制
    }
}
