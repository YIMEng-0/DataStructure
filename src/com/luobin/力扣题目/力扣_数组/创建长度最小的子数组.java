package com.luobin.力扣题目.力扣_数组;

/**
 * @author Doraemon
 * @date 2021/11/27 6:28 下午
 * @version 1.0
 */
public class 创建长度最小的子数组 {
    // 设置 32 位的最大值
    public static int INT32_MAX = 2147483647;

    /**
     *传递数组，阈值，找到最小的子数组
     * @param nums   寻找长度最小的子数组的原始数组
     * @param s    寻找最小的子数组的阈值
     * @return
     */
    public static int minSubArrayLen(int[] nums, int s) {
        int result = INT32_MAX; // 最终的结果
        int sum = 0; // 获取到的子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) { // 设置子序列起点为i
            sum = 0;
            for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
                sum += nums[j];     // 刚开始的 j = i 都是 0 ，i 保持不动，j 进行移动，寻找刚好大于目标数值的最小子序列
                if (sum >= s) { // 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1; // 取子序列的长度 终止的减去开始的就是数字之间的间隔，间隔加一就是数字的个数，一个间隔但是存在两个数字
                    result = result < subLength ? result : subLength;   //  始终选取比较小的 满足结果的数量
                    break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == INT32_MAX ? 0 : result; // 三目运算符，比较得到的结果
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};

        int length = minSubArrayLen(nums, 7);
        int length1 = minArrayLen(nums, 7);
        System.out.println("长度最小的子数组中包含的元素个数为：" + length);
        System.out.println("长度最小的子数组中包含的元素个数为：" + length1);
    }

    /**
     *传递数组，阈值，找到最小的子数组
     * @param arr   寻找长度最小的子数组的原始数组
     * @param target    寻找最小的子数组的阈值
     * @return
     */
    public static int minArrayLen(int[] arr, int target) {
        int result = 100;
        int sum;
        int subLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= target) { // 注意找到的最小的子数组，这里是有等于号的，在实际中需要注意
                    subLen = j - i + 1;
                    result = result < subLen ? result : subLen;
                    break;
                }
            }
        }
        return result;
    }
}