package com.luobin.力扣题目.力扣_链表.力扣707设计链表;

/**
 * @author Doraemon
 * @date 2021/12/15 3:52 下午
 * @version 1.0
 */
public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(5);
        list.addAtHead(4);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(1);
        list.traverse();
        int rs = list.get(4);
        System.out.println(rs);


    }
}
