package com.luobin.力扣数据结构练习题目.推荐学习的数据结构与算法.树;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/25 2:22 下午
 */

// 定义的类实现了 Comparable 类体

/**
 * 就是说：
 * 当想向二叉搜索树进行放置元素的时候，所添加的元素必须是可以进行比较的，强制的实现了可以比较的接口,
 */
public class Person implements java.lang.Comparable<Person> {
    private final int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int setAge() {
        return 0;
    }


    // 实现了接口，将相关的方法进行重写
    // 强制实现可以比较的接口，当前对象与传递进来的对象的年龄的比较结果
    @Override
    public int compareTo(Person e) {
        // 下面一句话包含了几个判断
        // compareTo() 当前的类里面的属性与传递进来的参数进行比较
        return age - e.age;
    }
}
