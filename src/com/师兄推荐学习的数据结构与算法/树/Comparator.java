package com.师兄推荐学习的数据结构与算法.树;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/25 6:03 下午
 * <p>
 * 通过上面的两个例子可以比较出 Comparable 和 Comparator 两者之间的区别：
 * <p>
 * 一个类实现了 Comparable 接口，意味着该类的对象可以直接进行比较（排序），但比较（排序）的方式只有一种，很单一。
 * 一个类如果想要保持原样，又需要进行不同方式的比较（排序），就可以定制比较器（实现 Comparator 接口）。
 * Comparable 接口在 java.lang 包下，而 Comparator 接口在 java.util 包下，算不上是亲兄弟，但可以称得上是表（堂）兄弟。
 * <p>
 * 通过上面的两个例子可以比较出 Comparable 和 Comparator 两者之间的区别：
 * <p>
 * 一个类实现了 Comparable 接口，意味着该类的对象可以直接进行比较（排序），但比较（排序）的方式只有一种，很单一。
 * 一个类如果想要保持原样，又需要进行不同方式的比较（排序），就可以定制比较器（实现 Comparator 接口）。
 * Comparable 接口在 java.lang 包下，而 Comparator 接口在 java.util 包下，算不上是亲兄弟，但可以称得上是表（堂）兄弟。
 * <p>
 * 通过上面的两个例子可以比较出 Comparable 和 Comparator 两者之间的区别：
 * <p>
 * 一个类实现了 Comparable 接口，意味着该类的对象可以直接进行比较（排序），但比较（排序）的方式只有一种，很单一。
 * 一个类如果想要保持原样，又需要进行不同方式的比较（排序），就可以定制比较器（实现 Comparator 接口）。
 * Comparable 接口在 java.lang 包下，而 Comparator 接口在 java.util 包下，算不上是亲兄弟，但可以称得上是表（堂）兄弟。
 */

/**
 * 通过上面的两个例子可以比较出 Comparable 和 Comparator 两者之间的区别：
 *
 * 一个类实现了 Comparable 接口，意味着该类的对象可以直接进行比较（排序），但比较（排序）的方式只有一种，很单一。
 * 一个类如果想要保持原样，又需要进行不同方式的比较（排序），就可以定制比较器（实现 Comparator 接口）。
 * Comparable 接口在 java.lang 包下，而 Comparator 接口在 java.util 包下，算不上是亲兄弟，但可以称得上是表（堂）兄弟。
 */

/**
 * 自己定义的比较器，模仿 JDK 而已
 *
 * @param <E>
 */
// 定义的比较器
// 实现它的类，必须实现 compare() 的方法
// 创建的 Comparator<E> 使用了范型的操作，就是无论什么数据都可以进行比较
public interface Comparator<E> {
    int compare(E e1, E e2);
}