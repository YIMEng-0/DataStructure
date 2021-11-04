package com.luobin.力扣题目.力扣_数组;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/10/18 2:30 下午
 */

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-by-leetcode-solutio/
 */

public class 替换空格 {
    public static void main(String[] args) {
        String string = "hello world";
        instead(string);
        int a = 0;
        System.out.println(++a);
        System.out.println(++a);
        System.out.println(++a);
    }

    public static void instead(String s) {
        int length = s.length();
        int index = 0;
        char[] array = new char[length * 3];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[index++] = '%';
                System.out.println(array);
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }

        System.out.println(array);
        System.out.println(array.length);
    }
}
