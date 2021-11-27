package com.luobin.力扣题目.力扣_数组;

/**
 * @author Doraemon
 * @date 2021/11/27 6:28 下午
 * @version 1.0
 */
public class 创建长度最小的子数组 {
    // 设置 32 位的最大值
    public static int INT32_MAX = 2147483647;

    public static int minSubArrayLen(int[] nums, int s) {
        int result = INT32_MAX; // 最终的结果
        int sum = 0; // 获取到的子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) { // 设置子序列起点为i
            sum = 0;
            for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= s) { // 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1; // 取子序列的长度
                    result = result < subLength ? result : subLength;
                    break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == INT32_MAX ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};

        int length = minSubArrayLen(nums, 7);
        System.out.println("长度最小的子数组中包含的元素个数为：" + length);
    }
}