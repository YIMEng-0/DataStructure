package com.luobin.力扣题目.力扣_数组;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/10 9:07 下午
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8};
        int rs = binarySearch(arr, 8);
        System.out.println("找到的数组的下标为：" + rs);

        System.out.println(Math.pow(2, 40));
    }

    /**
     * @param arr 数组
     * @param k   查询的数值
     * @return 返回找到的数组的下标
     */
    public static int binarySearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int NOT_FOUND = -1;

        while (left <= right) {
            // mid 的数值需要进行迭代的处理，因为是变化的
            mid = (left + right) / 2; // int 有一种向着下面取整的含义
            if (k < arr[mid]) {
                right = mid - 1;
            } else if (k > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return NOT_FOUND;

        /**
         * 时间复杂度：
         *  O(logn)
         */
    }
}
