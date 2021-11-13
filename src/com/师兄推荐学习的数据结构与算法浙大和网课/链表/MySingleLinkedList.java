package com.师兄推荐学习的数据结构与算法浙大和网课.链表;

import com.luobin.力扣题目.接口的定义.AbstractList;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/3 3:31 下午
 */

/**
 * 关于时间复杂度的问题，链表的数据操作中，只有在元素的插入或者删除的那一刻，时间复杂度是 O(1),整体封装好的函数来讲
 * 时间复杂度是：o(n)
 */
// 在类名后面指定尖括号意味着您正在创建一个可以保存任何类型数据的临时数据类型
public class MySingleLinkedList<E> extends AbstractList<E> {
    // 链表的大小
    private int size;
    // 链表的头结点，头结点是一个结构体，first 表示创建的指针
    private Node first;

    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }


    /**
     * 遍历链表查看是否包含传递进来的参数
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            first = first.next;
            if ((element).equals(first)) {
                System.out.println("true");
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    // 单独将元素添加进去
    // 采用调用按照索引添加的方式
    // 默认将元素添加到最后面
    public void add(E e) {
        // 此处调用了加入的方法，根据位置，进行元素的加入
        add(size, e);
    }

    /**
     * 插入的原理：
     * 1、找到需要加入的前面的一个元素，让前面的元素指向插入的元素，插入的元素指向后面的位置
     * 2、先进行插入操作，然后进行连接操作，为了使得连接顺畅，需要创建中间变量
     * 3、由于在插入的时候，后面有连接起来的操作，需要将pre.next 先保存到临时变量当中，结点使用自己的属性值以及指向下一个元素
     * <p>
     * 指针，也就是下一个元素的引用
     */
    @Override
    public void add(int index, E element) { // O(n)
        // 传入的索引为 0 ，在链表的最开始添加元素
        if (index == 0) {
            // 原始的链表中没有元素，构造器构造新的元素,创建出来第一个结点
            first = new Node<E>(element, first);

        } else {
            // Node<E> prev = node(index - 1);
            // 创建新的结点，元素是传进来的参数，下一个指针指向
            // 破坏了以前的结点所指向的下一个元素的连接，目前前一个结点的指针指向新的结点

            Node<E> prev = node(index - 1);

            // 前一个节点指向新加入的节点，新加入的节点指向原来的后面的节点
            prev.next = new Node<E>(element, prev.next);  // 链接了两条线
        }
        // 元素的数量的添加
        size++;
    }

    // 获取指定节点的 element 元素值
    @Override
    public E get(int index) { // O(1)
        return node(index).element;
    }

    // 将对应索引的元素值覆盖掉，返回原来的节点的 element
    // index 只能保证插入的结点的位置
    @Override
    public E set(int index, E element) {// O(1)
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 删除节点的思想：
     * 首先找到删除元素的前置节点，使得：前置节点.next = 前置节点.next.next；
     * 就是将不要的元素隔离掉
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node;

        if (index == 0) {
            // node 表示即将被删除的元素 做一下记录
            node = first;
            first = first.next;         // 隔空链接线路，实现元素的删除
        } else {
            // 获取索引前面的元素
            Node<E> prev = node(index - 1);
            // 定义的 node 是为了接收 找到的前一个元素的下一个元素的element
            node = prev.next;
            prev.next = prev.next.next;  // 隔空链接线路，实现元素的删除
        }

        size--;
        // 将删除的元素的值返回
        return node.element;
    }

    // 将需要寻找的对象传递进去，找到的话，返回索引
    @Override
    public int indexOf(E element) {
        // 允许了空值的传递，此处调用 下面的 equals() 会报错，需                                                      要处理
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i; // 遍历到最后面了 返回索引即可
                node = node.next;
            }
        } else {
            Node<E> node = first; // node 从头开始遍历的指针
            for (int i = 0; i < size; i++) {
                // 判断当前的对象与传入进去的对象是否一致
                // == 只是会比较引用地址
                // 把 element 放到前面，因为已经判断了，过来一定是非空的，使用 equals() 比较即可
                if ((element.equals(node.element))) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 写一个方法，通过索引返回需要找到的节点,在它的前面加节点
    // 获取 index 对应节点的对象
    // private 只能是同一个类才能使用,其他都不可以
    private Node<E> node(int index) { // O(n)
        rangeCheckForAdd(index);

        // first 最开始在链表的最前面，index 控制寻找到节点的次数
        // node充当一个指针，用来寻找节点
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        // java 中进行字符串的拼接 使用 StringBuilder,提升效率
        StringBuilder res = new StringBuilder();
        res.append("size = " + size + "\n");
        res.append("[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            // 添加元素
            res.append(node.element);

            // size 是数组的大小，实际比索引是大一个的，所以此处需要减去 1
            // 在每个元素之间添加逗号进行分隔
            if (i != size - 1) {
                res.append(",");
            }

            node = node.next;
        }
        res.append("]");
        return res.toString();
    }

    public void sizeGet() {
        System.out.println("size : " + size + "\n");
    }

    // 链表节点的设置问题
    private static class Node<E> {
        // 每个节点拥有自己的存储元素，同时也有自己的指向下一个元素的指针
        E element;
        Node<E> next;

        // 重写构造方法
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}