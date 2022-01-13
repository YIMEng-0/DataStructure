package com.luobin.力扣题目.力扣_链表.力扣024两两交换链表中的节点;

/**
 * @author Doraemon
 * @date 2021/12/31 3:36 下午
 * @version 1.0
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 设置虚拟头结点
        ListNode dummmyHead = new ListNode(0);

        ListNode cur = dummmyHead;
        dummmyHead.next = head;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;
            temp = cur.next;
            temp1 = cur.next.next.next;
            // 进行第一步的链接，第一个元素，链接到第三个元素
            cur.next = cur.next.next;

            // 第二步链接
            cur.next.next = temp;

            // 第三步的连接
            cur.next.next.next = temp1;

            cur = cur.next.next;
        }

        return dummmyHead.next;
    }
}