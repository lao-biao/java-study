package com.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        //测试选择排序
        int[] arr = {8, 3, 10, 6, 4, 1, 2, 7, 9, 5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectionSort(int[] array) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;    //记录最小值的位置

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
