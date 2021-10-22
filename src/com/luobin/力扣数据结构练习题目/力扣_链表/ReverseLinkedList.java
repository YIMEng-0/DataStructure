package com.luobin.力扣数据结构练习题目.力扣_链表;

// 原始的题目是反转列表

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/7 9:17 下午
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 */

/**
 * 题解的思想：
 * 1、创建两个指针进行遍历，pre 先指向 null ,cur 指向当前的元素，原来是 pre 指向了 cur ，形成了正向的链表，现在的目标将 cur 指向了 pre;
 * 形成了逆向的链表；
 * <p>
 * 2、从前面到后面进行 pre 和 cur 指针的移动；
 * 3、当 cur 成为空的时候，也就是 pre 此时指向了最后一个元素，返回的 pre 就是新链表的 head；
 * <p>
 * 注：java 中创建的结构体对象在堆中保存，它的引用在栈中保存，保存的是堆中的内存地址，C++ 的指针的传递，在 java 中是
 * 对象的引用的传递；
 * <p>
 * 为什么需要创建指针对象？
 * ListNode cur = head；
 * 上面的代码创建了一个 "对象指针" ；此时 head ,cur 同时指向了头节点，cur 是为了遍历从而创建的"指针"
 * 在后面引用也就变成了 "指针" ，因为他指向的对象是在链表中变化的，最初创建的
 * 对象会被垃圾回收器回收
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;

        while (cur != null) {
            // 将当前的链表对象的下一个结点进行保存
            // cur.next 后面的链表元素的地址

            // 留下联系方、
            tmp = cur.next;

            // 修改指针
            // 链表的逆方向赋值指针
            cur.next = pre;

            // 注意向后面移动的顺序 从前面向后面单个移动
            // 赋值运算符的运算顺序从右边向左边移动
            // 赋值的运算符是从右边向左边看，将右边的对象的地址赋值给左边的对象的地址，左边的引用指向了新的对象，原始创建的
            // 新的对象是会被垃圾回收器回收的
            // 继续往下走
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public class ListNode {
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
}