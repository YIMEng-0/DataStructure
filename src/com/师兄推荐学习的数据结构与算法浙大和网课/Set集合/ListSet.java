package com.师兄推荐学习的数据结构与算法浙大和网课.Set集合;

/**
 * @author Doraemon
 * @date 2021/11/22 6:45 下午
 * @version 1.0
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 使用链表对 Set 集合的实现
 * @param <E>
 */
public class ListSet<E> implements Set<E> {
    // 面向接口编程
    /**
     * 什么多态？
     *      同一个行为具有多种的表现形式；
     *      动物行走，不同的动物行走的方式是不一样的，这就是一种多态的表现形式
     *
     *      多态的实现方式
     *          方式一：重写：
     *              Java 重写(Override)与重载(Overload)。
     *          方式二：接口
     *              1. 生活中的接口最具代表性的就是插座，例如一个三接头的插头都能接在三孔插座中，因为这个是每个国家都有各自规定的接口规则，有可能到国外就不行，那是因为国外自己定义的接口类型。
     *              2. java中的接口类似于生活中的接口，就是一些方法特征的集合，但没有方法的实现。具体可以看 java接口 这一章节的内容。
     *
     *          方式三：抽象类和抽象方法
     */

    // 在编译的时候，是静态绑定，识别的是 List 接口，在运行时候，找到的是LinkedList ，进行了动态绑定
    private final List<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(Object element) {
        // 静态绑定阶段，与接口进行绑定，因为在接口中存在 contains 方法的，在运行的时候，进行动态绑定，实现相关的方法；
        return list.contains(element);
    }

    /**
     * 核心算法 Set 集合中添加元素，加入的元素需要是没有顺序（进去出来的顺序不一致，并且放进去的元素是不能重复的），
     * @param element
     */

    @Override
    public void add(Object element) {
        if (list.contains(element)) {
            return;
        } else {
            list.add((E) element);
        }
    }

    @Override
    public void remove(Object element) {
        int index = list.indexOf(element);

        if (list.contains(element)) {
            remove(element);
            System.out.println("已经删除了元素： " + element);
        }
    }


    /**
     * 使用链表进行遍历操作
     * @param visitor
     */
    @Override
    public void traversal(Visitor visitor) {
        if (visitor == null) {
            return;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (visitor.visit(list.get(i))) { // 当在遍历的时候得到了元素，那么就返回，否则就没有找到
                System.out.println("找到的元素是：" + list.get(i));
                return;
            }
        }
    }
}