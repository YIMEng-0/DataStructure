package com.师兄推荐学习的数据结构与算法浙大和网课.Set集合;

/**
 * @author Doraemon
 * @date 2021/11/22 5:24 下午
 * @version 1.0
 */
public interface Set<E> {
    int size();

    boolean isEmpty();

    void clear();

    boolean contains(E element);

    void add(E element);

    void remove(E element);

    void traversal(Visitor<E> visitor);

    // 其实就是静态类不用先创建外部类。可以静态类看做外部类的静态变量，
    // 使用就不要外部类实例(因为本身是静态的，不依赖于对象，也就是不依赖于实例)；而非静态就必须先实例化,
    abstract class Visitor<E> {
        boolean stop;

        abstract boolean visit(E element);
    }
}
