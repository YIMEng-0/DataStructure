package com.luobin.数据结构B站韩顺平.排序;

// 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端（升序或降序排列）
// 就如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”。

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/11 5:34 下午
 */
public class 冒泡Sort {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 3, 2, 1};
        sort1(arr, 5);

        System.out.println("排序后面的结果是：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort1(Integer[] array, int n) {
        // 如果排序数组规模小于等于1，直接返回
        if (n <= 1) {
            return;
        }

        // 有n个元素，进行n次冒泡
        for (int i = 0; i < n - 1; i++) {
            // 每一次冒泡，比较交换相邻两个元素
            // 上面的 i 表示是冒泡的趟数
            // 下面的 j 表示 每趟的比较次数，-i 表示没有排好的，还需要的次数，-1 防止索引越界
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) { // 左边的大于右边，进行交换，冒泡，一次冒泡
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}