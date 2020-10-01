package com.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        //测试插入排序
        int[] arr = {2, 3, 10, 9, 4, 8, 1, 7, 6, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {

            // 记录要插入的数据
            int temp = array[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                array[j] = temp;
            }

        }
    }
}
