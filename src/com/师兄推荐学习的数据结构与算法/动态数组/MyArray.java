package com.师兄推荐学习的数据结构与算法.动态数组;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/2 9:47 上午
 */

public class MyArray {

    public static void main(String[] args) {
        // new 向着堆空间申请内存，垃圾回收有无变量引用着这个对象，没有就回收
        // 在范型的左边写数据的对象类型才有用，右边可以不写
        MyArrayList<Object> persons = new MyArrayList();

        persons.add(new Person(10, "Jack"));
        persons.add(null);
        persons.add(new Person(11, "Tom"));
        persons.add(10);
        System.out.println(persons);
        System.out.println("null 空元素的位置是：" + persons.indexOf(null));

    }
    // 程序运行的时候，在此处会进行；垃圾回收，减少内存的消耗
}