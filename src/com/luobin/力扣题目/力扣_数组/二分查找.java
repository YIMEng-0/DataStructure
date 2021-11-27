package com.luobin.力扣题目.力扣_数组;

// https://leetcode-cn.com/problems/binary-search/

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/10 9:07 下午
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8};
        int rs = binarySearch(arr, 2);
        System.out.println("找到的数组的下标为：" + rs);

        System.out.println(Math.pow(2, 40));
    }

    /**
     * @param arr 查找目标元素所在的数组
     * @param target   查询的数值
     * @return 返回找到的数字的下标
     * 在这里使用的是左闭右闭的原则，左边是 0 右边是 6 ，是满足数组的索引的；
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int NOT_FOUND = -1;

        /**
         * 重点: 因为闭区间，所以到了begin等于end时，其实区间内还有一个值要判断，
         *      因此只有left > right的时候才能停止
         */
        while (left <= right) {
            // mid 的数值需要进行迭代的处理，因为是变化的
            mid = (left + right) / 2; // int 有一种向着下面取整的含义 ，每次将中间的这个结点进行更新即可
            if (target < arr[mid]) {
                right = mid - 1; // 因为比中间的小，不是中间的这个，所以查找的数据在中间的前面一位
            } else if (target > arr[mid]) {
                left = mid + 1;  // 同样的思路，比当前中间的大，不是中间的，查找的数据在中间数据的前面
            } else {
                return mid;     // 返回找到的元素的下标
            }
        }
        return NOT_FOUND;

        /**
         * 时间复杂度：
         *  O(logn) 底数在运算的过程不是十分重要的
         */
    }

    /**
     * 防止溢出的做法：
     *      // 防止溢出
     *             mid =  min + (max - min) / 2;
     *
     *      为什么会产生溢出的问题呢？
     *      假设max为int 最大值，第一次查找发现在后半部分，然后就是min = (max+0)/2 然后再进行max+mid就已经溢出了
     */
    public static int binarySearchPreventOverflow(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int NOT_FOUND = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            // 高级玩法 使用无符号右移一位的操作
            // mid = left + (right - left) >>> 1; 就是除以二使用了位运算代替了一下而已

            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return NOT_FOUND;
    }
}