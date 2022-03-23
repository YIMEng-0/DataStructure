package com.luobin.力扣题目.力扣_哈希表.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/4 3:36 下午
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 11, 3};
        int[] res = twoSum(arr, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println("数组的下标为 ： " + res[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        // 创建一个结果数组用来保存最终的结果
        int[] res = new int[2];

        // 判断传递进来的数组是不是空的
        if (nums.length == 0 || nums == null) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // 向着 Map 中进行添加元素，可以快速的寻找在 Map 中的元素；通过数值得到其索引；
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = i;
                // map.get() 方法通过 key 获取到  value 数值，这里的 value 就是保存的数组中的索引
                res[1] = map.get(temp);
            }
        }
        return res;
        // 为什么直接把所有的数值先放到 Map 中，然后遍历寻找，结果会出现错误呢？
        // 如果在 Map 中包含 Key ，那就是找到了，不需要继续在 Map 中放置元素了，否则还是需要放置元素的；没有找到那么就继续的向着 Map 中放置元素；
    }
}