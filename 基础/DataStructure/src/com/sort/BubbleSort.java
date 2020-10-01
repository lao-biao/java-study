package com.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //测试冒泡排序
//        int[] arr = {4, 2, 8, 6, 1, 3, 7, 9};
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(arr);
    }

    /**
     * 冒泡排序
     * 按小到大排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
