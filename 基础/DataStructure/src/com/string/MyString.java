package com.string;

/**
 * 测试串
 */
public class MyString {
    public static void main(String[] args) {
        //测试串的匹配暴力算法
        int index = indexByBruteForce("this is for test", "test");
        System.out.println("brute force：" + index);
        //测试串的KMP算法
        int ind = KMP("this is for test", "test");
        System.out.println("kmp：" + ind);
    }

    /**
     * 字符串匹配--暴力算法
     *
     * @param text    文本串
     * @param pattern 模式串
     * @return 匹配成功返回模式串第一次出现的位置
     */
    public static int indexByBruteForce(String text, String pattern) {
        int sLen = text.length();       //文本串字符长度
        int pLen = pattern.length();    //模式串字符长度

        char[] s = text.toCharArray();      //文本串字符
        char[] p = pattern.toCharArray();   //模式串字符

        if (sLen < pLen)    //文本串长度比模式串长度小，直接返回不匹配
            return -1;

        int i = 0;  //文本串指针位置
        int j = 0;  //模式串指针位置
        //while (i < sLen && j < pLen ) { 优化
        while (i < sLen && j < pLen && sLen - i + j >= pLen) {  //sLen - i + j >= pLen保证文本串有剩余字符能匹配成功
            if (s[i] == p[j]) {   //如果当前字符匹配成功，则继续匹配
                i++;
                j++;
            } else {  //如果失配，回溯
                i = i - (j - 1);    //从该次匹配成功的第一个字符的下一个字符开始
                j = 0;              //从第一个字符开始
            }
        }
        //匹配成功返回第一个字符的位置，匹配不成功，返回-1
        return j == pLen ? i - j : -1;
    }

    /**
     * @param text    主串
     * @param pattern 模式串
     * @return 如果匹配成功，返回下标，否则返回-1
     */

    public static int KMP(String text, String pattern) {
        if (text.length() < pattern.length() || pattern.length() == 0 || null == pattern) //
            return -1;
        //求模式串的next数组
        int[] next = new int[pattern.length()];
        next[0] = -1;
        for (int i = 1, k = -1; i < pattern.length(); i++) {
            if (k == -1 || pattern.charAt(i - 1) == pattern.charAt(k)) {
                k++;
                next[i] = k;
            } else {
                next[i] = 0;
                k = 0;
            }
        }
        //进行匹配
        for (int i = 0, j = 0; i < text.length(); ) {
            if (text.charAt(i) != pattern.charAt(j)) {
                if (next[j] == -1)
                    i++;
                else
                    j = next[j];
            } else {
                if (j == pattern.length() - 1)
                    return i - pattern.length() + 1;
                i++;
                j++;
            }
        }
        return -1;
    }
}


