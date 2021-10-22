package com.luobin.力扣数据结构练习题目.推荐学习的数据结构与算法.链表;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/18 10:38 上午
 */
public class TestMyDoubleLinkedList {
    public static void main(String[] args) {
        java.util.LinkedList list;

        MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList();
        String s = "124";

        // add()
        myDoubleLinkedList.add(11);
        myDoubleLinkedList.add(22);
        myDoubleLinkedList.add(33);
        myDoubleLinkedList.add(0, 44);
        System.out.println("删除前的元素为：" + myDoubleLinkedList);

        // remove()
        myDoubleLinkedList.remove(0);
        System.out.println("删除后的元素为：" + myDoubleLinkedList);

        // getSize()
        System.out.println("链表中的大小为：" + myDoubleLinkedList.getSize());

        // contains()
        boolean containsYesOrNo = myDoubleLinkedList.contains(33);
        System.out.println(containsYesOrNo);
    }
}