package com.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //测试快速排序
        int[] arr = {4, 2, 8, 6,10, 1, 3, 7, 9, 5};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        quickSort(array, start, end);
    }

    /**
     * 快速排序递归部分
     *
     * @param array
     * @param start
     * @param end
     */
    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {  //递归结束条件
            //从数列中取一个数作为基准数（简单起见取第一个数）
            int base = array[start];
            //左指针
            int pLeft = start;
            //右指针
            int pRight = end;
            //分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到他的左边（**分区**）
            while (pLeft < pRight) {    //pLeft!=pRight
                //从右到左，找到第一个小于基准值的值，将其移动到左指针的位置，并左指针+1
                while (pRight > pLeft) {
                    if (array[pRight] < base) {
                        array[pLeft] = array[pRight];
                        pLeft++;
                        break;
                    }
                    pRight--;
                }
                //从左到右，找到第一个大于基准值的值，将其移动到右指针的位置，并右指针-1
                while (pLeft < pRight) {
                    if (array[pLeft] > base) {
                        array[pRight] = array[pLeft];
                        pRight--;
                        break;
                    }
                    pLeft++;
                }
            }
            //基准值填坑
            array[pLeft] = base;
            //对左区间快排
            quickSort(array, start, pLeft - 1);
            //对右区间快排
            quickSort(array, pRight + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        /**
         * //分区过程
         * int index = partition(array, start, end);
         * //从数列中去一个数作为基准数（简单起见可以取第一个数）
         * int base = array[start];
         * //左指针
         * int pLeft = start;
         * //右指针
         * int pRight = end;
         * while (array[pRight] >= base && pLeft < pRight) {
         *     pRight--;
         * }
         * if (pLeft < pRight) {
         *     array[pLeft] = array[pRight];
         *     pLeft++;
         * }
         * while (array[pLeft] < base && pLeft < pRight) {
         *     pLeft++;
         * }
         * if (pLeft < pRight) {
         *     array[pRight] = array[pLeft];
         *     pRight--;
         * }
         * //基准值填坑
         * array[pLeft] = base;
         */
        return -1;   //pRight
    }
}
