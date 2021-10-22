package com.luobin.力扣数据结构练习题目.接口的定义;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/3 3:51 下午
 */

// 接口中存在的东西放上去之后，默认就是公共的，不需要加上 public
public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;

    void clear();

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int indexOf(E element);
}
