package com.师兄推荐学习的数据结构与算法.动态数组;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/2 11:45 下午
 */

/**
 *
 */
public class TestTwoSum {
    public static void main(String[] args) {
        TestTwoSum test = new TestTwoSum();
        int a = 1;
        int b = 2;
        System.out.println(test.sum(a, b));
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }
    /**
     * 因此可见：在Java中所有的参数传递，不管基本类型还是引用类型，都是值传递，或者说是副本传递。
     * 只是在传递过程中：
     *  1、如果是对基本数据类型的数据进行操作，由于原始内容和副本都是存储实际值，并且是在不同的栈区，因此形参的操作，不影响原始内容。
     *
     *  2、如果是对引用类型的数据进行操作，分两种情况，一种是形参和实参保持指向同一个对象地址，则形参的操作，会影响实参指向的对象的内容。
     *      一种是形参被改动指向新的对象地址（如重新赋值引用），则形参的操作，不会影响实参指向的对象的内容。
     */
}