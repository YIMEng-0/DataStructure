package com.luobin.力扣数据结构练习题目.师兄推荐学习的数据结构与算法.链表;

import com.luobin.力扣数据结构练习题目.接口的定义.AbstractList;

/**
 * 关于头指针和头节之间的关系
 * 头指针是指向头节点的，有的链表有头节点，有的链表没有头节点
 * 在下面的代码中， first 是指向第一个节点的指针 last 是指向最后一个节点的指针
 */
// 在类名后面指定尖括号意味着您正在创建一个可以保存任何类型数据的临时数据类型
public class MyDoubleLinkedList<E> extends AbstractList<E> {

    // 链表的大小
    private int size;
    // 创建双向链表的头指针和尾指针
    private Node<E> first;
    private Node<E> last;

    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
        /**
         * 分析：仅仅将 first last 进行断开，其他链表中的对象是否可以存在？
         *      不可以存在，因为 java 虚拟机底层的实现原理，
         *      gc root 对象，对象被这个指着，对象才不会被销毁
         *          1、栈指针指向的对象（也就是说局部变量指向的对象）
         *              在栈中，存放的是对象的引用，栈的指针被干掉了，堆中的对象就消失了
         *              在这段代码中，只有 first 和 last 被断开，那么栈指针指向的对象就没了，没有被指针指向的对象就会被销毁
         *
         *          2、一旦 gc root 对象指向对象，创建出来的对象就会消失
         */
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
            // 借用一下 first 因为 first 指向的是链表的最前面，方便循环，运行结束后，局部变量会被销毁，全局变量会剩下来

            if ((element).equals(first.element)) { // 前面的还没有加，可以比较第一个
                return true;
            } else {
                first = first.next; // 后面的加上去，全部比较
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
     * 双向链表，每个元素需要使用四个线条进行连接；
     * 1、创建构造函数里面的需要参数，使用 node 索引找到需要占用的位置，就是新加入的元素放到 index 的位置
     * 原来位置的元素当作插入的新元素的下一个元素，自己的坑位被占掉了，被插队了；
     * 2、进行连接操作，next.prev = node; prev.next = node;
     * 3、考虑到 0 位置的添加，因为 0 位置的 prev 是 null ，会出现 null.next = node，即空指针异常的问题
     * 所以考虑将 first = node;进行连接解决问题
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) { // O(n)
        /**
         * 将元素放在头部，考虑 first last 的指向；节点本身的指向
         */
        if (index == size) { // 向最后面添加元素，不需要减去 1 ，减去 1 就是插入完后变成了倒数第二个元素

            // 最后添加的元素，构造函数，第一个参数指向以前的 last ，最后一个参数指向 null
            // 再将 last 指针指向新加入的节点，构成完美的双向链表
            Node<E> oldLast = last; // oldLast == null
            last = new Node<E>(oldLast, element, null); // 这里面连接了三个线
            // 旧的 最后一个指向新的最后一个节点
            // oldLast 可能为空，因为一开始 index == size 出现空指针异常
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;                             // 这里连接了一个线
            }

            size++;

            /**
             *  1、创建最后需要插入的节点
             *  2、把最后一个结点连接起来，四个指针，四条线
             */

        } else {
            // 举例：向 2 的前面位置添加节点，2 就是新添加节点的下一个
            // 新加入的元素刚好所占到的位置就是 index 的位置
            Node<E> next = node(index);

            // 新添加节点的上一个节点就是 index 对应的节点的上一个（原来就是这样指向的）
            Node<E> prev = next.prev;

            // 新节点的三个参数，都已经找到，满足节点的 数据结构
            Node<E> node = new Node<>(prev, element, next);   // 连接到了两个线

            // 后面的节点 prev 指向新的节点，前面的节点的 next 也指向新的节点

            if (prev == null) { // index == 0 等价于           // 再连接两条线
                // 前面结点的下一个连接新加入结点，后面的前一个连接新节点
                first = node;
                next.prev = node;
            } else {
                prev.next = node;
                next.prev = node;
            }
            size++;
        }
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
        /**
         * 找到需要被处理的对象，将其前面后面，进行顺序链接即可
         */
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) { // 等价于：index == 0             // 链接一条线
            // 删除的索引是 0 的元素，跳过 0 进行链接即可
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) { // 等价于 index == size - 1        // 再链接一条线
            // 让最后的节点指向（最后一个节点的上一个 ）（统称为 prev）
            last = prev;
        } else {
            next.prev = prev;
        }

        size--;
        // 将删除的元素的值返回
        return node.element;
    }

    // 将需要寻找的对象传递进去，找到的话，I
    @Override
    public int indexOf(E element) {
        // 允许进行空值的查询，返回第一个元素为空的索引
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
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

        // << 左边是乘法，右边是除法
        // 小于一半，是在左边的位置
        if (index < size >> 1) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.next;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        // java 中进行字符串的拼接 使用 StringBuilder,提升效率
        StringBuilder res = new StringBuilder();
        res.append("size = " + size + "\n");
        res.append("[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            res.append(node.element);

            // size 是数组的大小，实际比索引是大一个的，所以此处需要减去 1
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

        // 考虑到当前节点的前面一个节点是什么，当前元素的内容是什么，下一个节点是什么
        Node<E> prev;
        E element;
        Node<E> next;

        // 重写构造方法
        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}