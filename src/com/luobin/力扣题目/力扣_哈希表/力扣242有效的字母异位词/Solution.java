package com.luobin.力扣题目.力扣_哈希表.力扣242有效的字母异位词;

import java.util.Arrays;

/**
 * @author Doraemon
 * @date 2022/1/16 8:27 下午
 * @version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        String s = "12345";
        String t = "54321";
        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        // 比较字符串的长度，长度不一致的话直接返回 false 即可
        if (s.length() != t.length()) {
            return false;
        }

        // 转换成为字符数组类型，方便对单个字符数组进行排序，查看里面的元素是否是相同的
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        // 进行排序处理
        Arrays.sort(str1);
        Arrays.sort(str2);

        // 进行比较即可，调用了 Arrays 里面的比较函数
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram1(String s, String t) {
        // 除了使用排序的方式直接进行比较之外，可以使用哈希表m也就是使用数组进行字母的异位词的判断


        int[] record = new int[26];

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        for (int i = 0; i < str1.length; i++) {
            record[str1[i] - 'a'] += 1;
        }

        for (int i = 0; i < str2.length; i++) {
            record[str2[i] - 'a'] -= 1;
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }

        return true;
    }
}


