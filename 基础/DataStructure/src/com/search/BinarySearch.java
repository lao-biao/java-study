package com.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        //测试二分查找
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = binarySearch(arr, 4);
        System.out.println("该值的索引位置是：" + index);
    }

    /**
     * 二分查找
     * 功能：在数组中查找指定的值，返回返回第一个匹配到的索引值
     * <p>
     * 所求的值存在，返回第一个匹配到的索引值
     * 所求的值不存在，返回-1
     * <p>
     * 时间复杂度：T(n)=O(log2 n)
     * 空间复杂度：S(n)=O(n)
     *
     * @param array 有序表
     * @param value 所求值
     * @return
     */
    public static int binarySearch(int[] array, int value) {
        //指定low和high
        int low = 0;
        int high = array.length - 1;
        //二分查找
        while (low <= high) {
            //求得middle
            int middle = (low + high) / 2;
            if (array[middle] == value) //判断是否等于
                return middle;
            else if (array[middle] > value) //在小的部分
                high = middle - 1;
            else    //在大的部分
                low = middle + 1;
        }
        return -1;
    }

    /**
     * 二分查找--递归
     * 时间复杂度：T(n)=O(log2 n)
     * 空间复杂度：S(n)=O(log2 n)
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearchByRecursion(int[] array, int value) {
        //指定low和high
        int low = 0;
        int high = array.length - 1;
        return binarySearchByRecursion(array, value, low, high);
    }

    public static int binarySearchByRecursion(int[] array, int value, int low, int high) {
        if (low > high) //递归结束条件--没找到
            return -1;
        int middle = (low + high) / 2;
        if (value == array[middle]) //递归结束条件--找到
            return middle;
        else if (value < array[middle])
            return binarySearchByRecursion(array, value, low, middle);
        else
            return binarySearchByRecursion(array, value, middle, high);
    }
}
