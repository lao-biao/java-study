package com.search;

/**
 * 顺序查找
 *
 */
public class OrderSearch {
    public static void main(String[] args) {
        //测试顺序表查找
        int[] arr = {1, 2, 3, 8, 5, 9, 6};
        int index = orderSearch(arr, 5);
        System.out.println("该值的索引位置是：" + index);
    }

    /**
     * 顺序查找
     * 功能：在数组中查找指定的值，返回返回第一个匹配到的索引值
     *
     * 所求的值存在，返回第一个匹配到的索引值
     * 所求的值不存在，返回-1
     *
     * 时间复杂度：T(n)=O(n)
     * 空间复杂度：S(n)=O(1)
     * @param array 查找表
     * @param value 所求的值
     * @return
     */
    public static int orderSearch(int[] array, int value) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                index = i;
                break;  //去除break则返回最后一个匹配到的值的位置
            }
        }
        return index;
    }
}
