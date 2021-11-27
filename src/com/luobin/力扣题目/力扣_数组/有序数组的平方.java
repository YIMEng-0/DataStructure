package com.luobin.力扣题目.力扣_数组;

// https://leetcode-cn.com/problems/squares-of-a-sorted-array/

/**
 * @author Doraemon
 * @date 2021/11/27 2:06 下午
 * @version 1.0
 */
public class 有序数组的平方 {
    public static void main(String[] args) {
        System.out.println("===开始测试数组中元素的平方===");
        int[] arr = {-5, -3, 3, 2};

        int[] rsArr = sortedSquares(arr);

        for (int i = 0; i < rsArr.length; i++) {
            System.out.println("新数组的元素为：" + rsArr[i]);
        }
    }

    /**
     * @param arr 每个元素待平方的数组
     * @return 排好序的每个元素平方后的结果
     */
    public static int[] sortedSquares(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int k = arr.length - 1;
        int[] newArr = new int[arr.length];
        while (left <= right) {
            if (arr[left] * arr[left] < arr[right] * arr[right]) {
                newArr[k] = arr[right] * arr[right];
                right--;
                k--;
            } else {
                newArr[k] = arr[left] * arr[left];
                left++;
                k--;
            }
        }
        return newArr;
    }
}
