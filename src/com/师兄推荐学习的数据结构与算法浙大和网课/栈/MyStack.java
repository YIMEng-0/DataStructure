package com.师兄推荐学习的数据结构与算法浙大和网课.栈;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/23 11:13 上午
 */
public class MyStack<E> extends MyArrayList {
    public boolean isEmpty() {
        return isEmpty();
    }

    // 向着栈顶添加元素
    public void push(E element) {
        add(element);
    }

    public E pop() {
        return (E) remove(size - 1);
    }

    public E top() {
        return (E) get(size - 1);
    }
}
