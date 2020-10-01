package com.grammar;

/**
 * 自动装箱与拆箱
 */
public class AutoBoxing {
    public static void main(String[] args) {
        Integer integer1 = 1;    //自动装箱
        Integer integer2 = Integer.valueOf(1);

        int int1 = integer1;    //自动拆箱
        int int2 = integer2.intValue();
    }
}
