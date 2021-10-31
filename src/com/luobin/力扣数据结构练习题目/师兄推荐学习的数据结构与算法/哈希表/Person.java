package com.luobin.力扣数据结构练习题目.师兄推荐学习的数据结构与算法.哈希表;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/10/30 4:02 下午
 */

import java.util.Objects;

/**
 * 自定义对象的哈希值的计算
 */
public class Person {
    private final int age;
    private final float height;
    private final String name;

    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }


    // 自己实现 hashCode 并且 hashCode 值与age height name 是有关系的；
    // 下面的方法中计算的哈希值，是使用了 整数的拆解算法实现的；
    @Override
    public int hashCode() {

        // 为什么使用了 31 作为乘数？
        // 因为 31 在JVM 会进行调优，比其他数字的乘法的运算效率会高一些
        int hashCode = Integer.hashCode(age);
        hashCode = hashCode * 31 + Float.hashCode(height);
        hashCode = hashCode * 31 + name != null ? name.hashCode() : 0;

        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Person person = (Person) object;

        // 比较成员变量
        return age == person.age
                &&
                Float.compare(person.height, height) == 0
                &&
                Objects.equals(name, person.name);
    }
}
