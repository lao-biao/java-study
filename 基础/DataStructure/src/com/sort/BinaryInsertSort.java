package com.sort;

import java.util.Arrays;

/**
 * 二分插入排序
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 9, 4, 8, 1, 7, 6, 5};
        binaryInsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void binaryInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];  //要操作的数
            int low = 0;
            int high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (temp > arr[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            //从后往前移动数组，直到temp要插入的位置
            for (int j = i - 1; j >= low; j--)
                arr[j + 1] = arr[j];
            //插入
            arr[low] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
