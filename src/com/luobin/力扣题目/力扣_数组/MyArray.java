package com.luobin.力扣题目.力扣_数组;

/**
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 */

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/28 12:18 下午
 */
public class MyArray {
    public static void main(String[] args) {
        int[] testNums = new int[]{1, 2, 3, 4, 5, 6};

        int[] result = MyArray.solution(testNums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 如果没有static, 那么这个方法就是类的成员方法, 调用的时候需要通过这个类的对象来调用, 加上static就变成类的静态方法,
     * 静态方法要通过类直接调用, 不能通过类的对象进行调用
     *
     * @param nums
     * @return nums 这是一个新计算好的结果，每一个位置都已经进行了重新的计算
     */

    public static int[] solution(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}