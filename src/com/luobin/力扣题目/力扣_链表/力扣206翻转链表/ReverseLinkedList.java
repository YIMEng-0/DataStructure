package com.luobin.力扣题目.力扣_链表.力扣206翻转链表;

/**
 * @author Doraemon
 * @date 2021/12/30 10:56 上午
 * @version 1.0
 */
public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
        // 将链表的头结点传递进来进行链表的翻转操作
        ListNode temp; // 保存cur.next 防止找不到链表的其余部分；
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre; // 指针调整方向

            pre = cur;
            cur = temp;
        }

        return pre; // 不是返回 cur 因为 cur 最终指向了空，一个链表不能最终的头结点是一个空
    }
}
