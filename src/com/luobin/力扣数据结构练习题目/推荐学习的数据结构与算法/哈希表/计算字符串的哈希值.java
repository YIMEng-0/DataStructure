package com.luobin.力扣数据结构练习题目.推荐学习的数据结构与算法.哈希表;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/10/30 3:43 下午
 */
public class 计算字符串的哈希值 {
    public static void main(String[] args) {
        String string = "jack";
        int hashCode = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
//            hashCode = hashCode * 31 + c;  // 3254239
            hashCode = (hashCode << 5) - hashCode + c;
        }

        System.out.println(hashCode);
        System.out.println(string.hashCode()); // 自动将 hashCode 计算好了


        Integer a = 110;
        Float b = 10.9f;
        Long c = Long.valueOf(123);
        Double d = 10.89898;
        String e = "csdc";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(e.hashCode());


    }
}
