package com.luobin.力扣数据结构练习题目.力扣_链表;

//  https://leetcode-cn.com/problems/linked-list-cycle/

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/9 9:55 下午
 */

/**
 * 关于快慢指针，为什么需要快指针前进两步，慢指针前进一步，因为在每一运行一次 for 循环的时候，两个指针之间的距离就会缩小一小步
 * 导致在最终的时候，就会出现一定会相遇，这是设计的巧妙之处；
 * <p>
 * 从数学的角度来讲：两个指针之间的距离是： n + 1 - 2 （慢的向前移动一个，所以 + 1，快的向前移动两个，距离 - 2）也就是 n - 1
 * 所以两个指针之间的距离是一定会减小的
 */
public class 判断环形链表 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用快慢指针的思想，有环形的话，会进行相遇，相遇就是，两个指针指向的节点是一样的
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 对于头节点的判断，空或者只有一个元素是 false 没有环的
            if (head == null || head.next == null) return false;

            // 开始的时候，不要相遇，快指针放到前面一点
            // 创建的指针，指向头节点，会自动进行遍历
            ListNode slow = head;
            ListNode fast = head.next;

            // 因为前面的节点跑在前面，前面的都已经空了，还没有相遇，说明没有环了，停止
            // 一个变量是null,及只有其名,没有实值内容,也没分配内存,当你要去取他的长度,
            // 对他进行操作就会出现NullPointException,所以生命一个变量时最好给它分配好内存空间，给予赋值
            // 空指针异常，简单来说就是对象只有引用的地址，指向的地址没有实际的内容
            while (fast != null && fast.next != null) {
                if (slow == fast) return true;

                // 往下面遍历循环
                slow = slow.next;
                fast = fast.next.next;
            }

            // 上面进行寻找是否有环，在这里发现了没有环形链表，所以返回 false
            return false;
        }
    }
}