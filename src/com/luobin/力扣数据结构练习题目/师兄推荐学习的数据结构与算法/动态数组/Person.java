package com.luobin.力扣数据结构练习题目.师兄推荐学习的数据结构与算法.动态数组;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/2 8:57 下午
 */
public class Person {
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // 进行垃圾的回收
    // 相当于C++ 的析构函数
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("垃圾 - 回收了");
    }

    // 可以重写 equals 方法，自己定义对象在什么情况下是相等的


    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    // 定义：只要两个对象的年龄是相同的，那么两个对象就是相等的
    // 定义了之后，定义在什么情况下对象才是相等的
    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;

        // 使用普通数据类型，比较值的大小
        // 穿进来的对象和当前的对象比较
        return this.age == person.age;
    }

    // Integer 内部默认比较的是数值的大小，不是地址
    /**
     * 　　1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
     * 　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址
     * 　　2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量
     * 　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
     * 　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
     */

    /**
     *  为什么需要重写 equals?
     *      因为使用 == 对于引用数据类型，只能简单比较地址是否相同，使用 equals 可以自己定义相等的条件，增强代码
     */
}