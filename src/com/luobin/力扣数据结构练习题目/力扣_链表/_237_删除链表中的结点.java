package com.luobin.力扣数据结构练习题目.力扣_链表;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/7 8:52 下午
 * <p>
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的结点 {

    /**
     * 实现思路：
     * 找到需要删除的元素的下一个结点，将其下一个结点的 val 值赋值到需要删除的结点 val 值，将需要删除的结点指向 next.next
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
