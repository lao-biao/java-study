package com.lineartable;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 测试deque
 * 十进制转换成2进制
 */
public class TestConvert {
    public static void main(String[] args) {
        int num = 13;
        int temp = num;
        Deque<Integer> stack = new LinkedList<>();
        while (temp > 0) {
            int mod = temp % 2;
            stack.push(mod);
            temp = temp >> 1;
        }
        System.out.print(num + "--->");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
