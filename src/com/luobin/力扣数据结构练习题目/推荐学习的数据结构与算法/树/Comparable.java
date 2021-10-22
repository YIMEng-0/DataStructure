package com.luobin.力扣数据结构练习题目.推荐学习的数据结构与算法.树;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/25 2:09 下午
 */

/**
 * 通过上面的两个例子可以比较出 Comparable 和 Comparator 两者之间的区别：
 * <p>
 * 一个类实现了 Comparable 接口，意味着该类的对象可以直接进行比较（排序），但比较（排序）的方式只有一种，很单一。
 * 一个类如果想要保持原样，又需要进行不同方式的比较（排序），就可以定制比较器（实现 Comparator 接口）。
 * Comparable 接口在 java.lang 包下，而 Comparator 接口在 java.util 包下，算不上是亲兄弟，但可以称得上是表（堂）兄弟。
 *
 * @param <E>
 */
public interface Comparable<E> {
    int compareTo(E e);
}
