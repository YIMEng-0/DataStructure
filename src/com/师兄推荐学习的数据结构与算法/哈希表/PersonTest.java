package com.师兄推荐学习的数据结构与算法.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/10/30 4:04 下午
 */
public class PersonTest {
    public static void main(String[] args) {
        Car car = null;
        Person p1 = new Person(99, 1.89f, "Jack");
        Person p2 = new Person(99, 1.89f, "Jack");
        Person p3 = new Person(99, 1.89f, "Jack");

        // 对象都是继承了 Object 对象的，都是存在 hashCode() 方法的，和对象的存储的地址是挂钩的，不同的对象 hashCode 是不一样的
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        Map<Object, Object> map = new HashMap<>();
        map.put(p1, "123");
        map.put(p2, "456");
        map.put(p3, "567");
        System.out.println(map.size());

        /**
         * 假设需求，当一个人的年龄，身高，名字相同的时候，判断两个人是同一个人，但是上面的哈希值都是不同的，存储在哈希表的key不同，
         * hashCode 也是不同的，
         */
    }
}