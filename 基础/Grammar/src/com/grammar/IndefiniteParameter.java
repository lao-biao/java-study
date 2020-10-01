package com.grammar;

/**
 * 不定项参数
 */
public class IndefiniteParameter {
    public static void main(String[] args) {
        //测试不定项参数
        print();    //无参，调用print(String... message)
        print("Hello world!"); //一个参数，调用固定参数方法print(String message)
        //print("Hello", "world");    //编译器报错：Ambiguous method call. Both print(String... message) and (String str, String... message) in IndefiniteParameter match

    }

    /**
     * 固定参数
     *
     * @param message
     */
    static void print(String message) {
        System.out.println(message);
    }

    /**
     * 不定项参数
     *
     * @param message
     */
    static void print(String... message) {
        if (message == null || message.length == 0) {
            System.out.println("无参");
            return;
        }
        for (String seq : message) {
            System.out.println(seq);
        }
    }

    /**
     * 不定项参数
     *
     * @param str
     * @param message
     */
    static void print(String str, String... message) {
        for (String seq : message) {
            System.out.println(seq);
        }
    }

}
