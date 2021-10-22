package com.luobin.力扣数据结构练习题目.推荐学习的数据结构与算法.链表;

import com.luobin.力扣数据结构练习题目.接口的定义.List;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/6 8:32 下午
 */
public class TestLinkedList {
    public static void main(String[] args) {
        List<String> list = new MySingleLinkedList<>();

        // add()
        list.add("1");
        list.add("2");
        list.add("3");

        // indexOf()
        int index = list.indexOf("3");
        System.out.println("查询到的索引值为：" + index);

        // remove()
        list.remove(2);

        // clear()
//        list.clear();

        // toString()
        System.out.println(list);
    }
}