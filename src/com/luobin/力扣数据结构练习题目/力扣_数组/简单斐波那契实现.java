package com.luobin.力扣数据结构练习题目.力扣_数组;

/**
 * 斐波那契数字的实现
 */

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/30 3:38 下午
 */
public class 简单斐波那契实现 {
    public static void main(String[] args) {
//        int[] array = new int[10];
//        array[0] = 0;
//        array[1] = 1;
//        for (int i = 2; i < array.length; i++) {
//            array[i] = array[i - 1] + array[i - 2];
//        }
//
//        for (int i : array) {
//            System.out.println(i);
//        }

        // 阶乘
        简单斐波那契实现 jieChen = new 简单斐波那契实现();
        int res = jieChen.JieChen(3);
        System.out.println("\n阶乘的计算结果是：" + res);

        // 另一种简单方式的递归理解
        jieChen.factrialDetail(5);
    }


    public int JieChen(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * JieChen(n - 1);
        }
    }


    public int factrialDetail(int n) {
        if (n < 1) {
            System.out.println("拆解问题完毕，开始分而治之");
            return 1;
        }

        System.out.println("f(" + n + ")=" + n + " * f(" + (n - 1) + ")");
        int z = n * factrialDetail(n - 1);

        System.out.println("f(" + n + ")=" + z);

        return z;
    }
}