package com.luobin.力扣题目.力扣_链表;

/**
 * @author Doraemon
 * @date 2021/12/4 7:43 下午
 * @version 1.0
 */

/**
 * 节点被认为是一个实体，有处理能力，比如网络上的一台计算机；
 * 而结点则只是一个交叉点，像“结绳记事”，打个结，做个标记，仅此而已，还有就是，要记住：一般算法中点的都是结点。
 */
public class 力扣203移除链表指定元素 {
    /**
     * 使用虚拟头结点，将所有的删除操作进行统一
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElement(ListNode head, int val) {
        // 当链表为空的时候，将原始的链表头结点返回回去即可
        if (head == null) {
            return head;
        }

        // 设置虚拟头结点，虚拟头结点的值可以任意，但是它指向的下一个元素就是链表的头结点
        ListNode virtual = new ListNode(-1, head);

        // 前面的指针指向虚拟头结点，待删除元素的前驱结点
        ListNode pre = virtual;
        // 后面的指针指向原始的头结点，拟待删除元素的结点
        ListNode cur = head;

        // cur 保证了遍历了所有的元素，将所有的元素进行了比较，保证了元素没有没遗落，空的话就是不需要进行比较了
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;  // 建立链接，跳过中间的元素
            } else {
                pre = cur;  // 到了这里说明没有找到需要删除的元素，前面的链接是稳定的， pre 到达这个 cur 的位置，当做拟删除元素结点的前驱结点
            }
            cur = cur.next; // 向后面遍历，寻找潜在的可以删除的元素
        }

        // 虚拟结点的下一个结点才是真的头结点，上述的算法，进行了删除所有元素的统一
        return virtual.next;
    }

    /**
     * 不使用虚拟头结点，直接对于头结点进行特殊处理即可
     *
     * 进行元素的删除，首先使用普通的方法进行删除，不设置虚拟结点，直接删除即可
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 如果一个链表中每次删除的都是头结点，头结点后面有好几个都是待删除的元素，需要特别的进行处理
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur; // 前面的指针直接指向当前的指针
            }
            cur = cur.next;
        }

        return head; // 返回删除后的元素的链表，就是返回链表的头结点，通过链表的头结点，可以对于链表进行遍历获取元素等操作
    }
}

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