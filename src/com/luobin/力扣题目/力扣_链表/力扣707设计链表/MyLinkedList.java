package com.luobin.力扣题目.力扣_链表.力扣707设计链表;

/**
 * @author Doraemon
 * @date 2021/12/15 11:08 上午
 * @version 1.0
 */

/**
 *          int get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *          addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *          addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *          addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 *      如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 *          deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class MyLinkedList {
    // 设计的链表中元素的个数
    int size;

    // 设置一个虚拟头结点，虚拟头结点，得到一个虚假的头结点，方便后面的操作
    MyListNode head;

    // 链表的初始化
    public MyLinkedList() {
        size = 0;
        head = new MyListNode(-1);
    }

    /**
     * 首先写在链表中进行元素的插入的方法，指定元素的位置进行插入
     *
     * 插入元素之后，插入的元素占用的位置就是 Index 位置
     * 插入的元素 index 等于链表的长度，就是插入到链表的尾部
     * 插入的元素 index 等于 0 ，就是在链表的头部插入元素
     *
     * Index 是链表的索引，元素的个数是等于 链表的索引加上 1 的
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            System.out.println("插入的元素的索引超过了链表的最大长度，无法插入");
            return;
        }

        if (index < 0) {
            System.out.println("插入的元素索引是负数，自动将其插入到了链表的头结点");
            index = 0;
        }

        // 这个元素个数加一放置的十分巧妙，同时兼顾了上面以及下面否则，在 if(index < 0)里面 以及最下面都要放置 size++
        size++;

        // 找到插入结点的前驱结点，需要使用循环进行遍历
        MyListNode pre = head;

        // index 始终表示的是索引，它与实际的链表的长度是不一样的
        // 链表的 size 使用是最大索引加一
        for (int i = 0; i < index; i++) {
            // 循环里面存在了一个遍历以及迭代的操作，一直找到待插入元素结点
            pre = pre.next;
        }

        // 创建新节点，进行插入进去
        MyListNode newAdd = new MyListNode(val);

        // 上面找到了位置，创建结点，与上面的 pre.next 进行连接
        // 从后面到前面进行链表的链接；
        // 自己的惯性思路是从前面到后面进行连接，需要注意
        newAdd.next = pre.next;
        pre.next = newAdd;

        // 自己的惯性插入思路
        // pre.next = newAdd.next;
        // newAdd.next = pre.next; // 错误的，因为 pre ,画图发现线的连接存在问题
    }

    /**
     * 将元素插入到头部
     * @param val 插入的数值
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * 将元素插入到链表的尾部
     * @param val 插入的数值
     */
    public void addAtTail(int val) {
        addAtIndex(size - 1, val);
    }

    // 在单链表中进行元素的删除

    /**
     * 通过索引删除元素
     * @param index
     */
    public void deleteByIndex(int index) {
        if (index >= size || index < 0) {
            System.out.println("删除元素超过索引");
            return;
        }

        size--;

        // 元素的删除，先找到前面的结点，再进行删除
        MyListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }


    /**
     * 进行元素的遍历，将当前的结点指定为 cur 在循环中进行控制遍历
     */
    public void traverse() {
        // 避免空指针异常在 cur 在方法内部进行定义
        MyListNode cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            System.out.println("链表当前的数值为：" + cur.val);
        }
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        MyListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        // 找到当前的元素
        return cur.val;
    }
}

/**
 * 创建使用的结点，里面保存一个数值，一个指向下一个结点的指针，或者是引用
 */
class MyListNode {
    int val;
    MyListNode next;

    public MyListNode() {
    }

    public MyListNode(int val) {
        this.val = val;
    }
}