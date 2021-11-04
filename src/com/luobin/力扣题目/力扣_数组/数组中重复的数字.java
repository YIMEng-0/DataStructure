package com.luobin.力扣题目.力扣_数组;

import java.util.Arrays;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/10/18 2:08 下午
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {12, 3, 4, 5, 6, 2, 3, 4, 2, 3, 4, 3};
        int repeatNumIs = findRepeat(nums);
        System.out.println("重复的数字是：" + repeatNumIs);
    }

    public static int findRepeat(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }
}

