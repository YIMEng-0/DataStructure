package com.luobin.力扣题目.力扣_哈希表.力扣242有效的字母异位词;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Doraemon
 * @date 2022/1/17 4:44 下午
 * @version 1.0
 */
public class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        // 除了使用排序的方式直接进行比较之外，可以使用哈希表m也就是使用数组进行字母的异位词的判断
        // 将元素存储在哈希表中，使用散列的方式维护一个字符出现的频数表
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> table = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);

            if (table.get(ch) < 0) {
                return false;
            }

        }
        return true;
    }
}
