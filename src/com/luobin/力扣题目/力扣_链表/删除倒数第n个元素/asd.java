package com.luobin.力扣题目.力扣_链表.删除倒数第n个元素;

/**
 * @author Doraemon
 * @date 2022/1/13 6:23 下午
 * @version 1.0
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 题目概述：
 *    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 首先让fast 指针移动 n 个位置，方便进行元素的删除处理
        while (n != 0) {
            fast = fast.next;
            n = n - 1;
        }
        /**
         上面的  while 循环可以使用下面的第二中方式：
         while(n-- > 0) {
         fast = fast.next；
         }

         两个循环都是为了让 fast 指针进行移动 n 次；说白了就是控制循环的次数
         */

        // 定义一个临时结点，用来保存 slow 结点的上一个结点
        ListNode prev = null;
        // 这样子可以进行链表的连接操作， slow 的上一个结点连接到 slow 的下一个结点，刚好把 slow 指向的当前结点删除掉
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // 位置找到了，进行链表的连接，删除 slow 指向的元素
        prev.next = slow.next;
        return dummyHead.next;
    }
}