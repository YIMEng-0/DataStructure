package com.luobin.力扣题目.力扣_链表.力扣206翻转链表;

/**
 * @author Doraemon
 * @date 2021/12/30 10:57 上午
 * @version 1.0
 */

/**
 * 创建出来的 结点，一个保存数值，一个保存指向下一个结点的地址
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
