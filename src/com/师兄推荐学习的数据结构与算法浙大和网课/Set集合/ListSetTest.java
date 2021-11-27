package com.师兄推荐学习的数据结构与算法浙大和网课.Set集合;

/**
 * @author Doraemon
 * @date 2021/11/22 5:23 下午
 * @version 1.0
 */
public class ListSetTest {
    public static void main(String[] args) {
        Set<Integer> listSet = new ListSet<>();

        listSet.add(10);
        listSet.add(20);
        listSet.add(20);
        listSet.add(40);
        listSet.add(60);
        listSet.add(60);

        // 下面的匿名类实现了抽象父类
        // 匿名类实现了抽象父类
        Set.Visitor visitor = new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) { // 对于接口中的抽象类进行了实现

                System.out.println(element);
                return false;
            }
        };
        listSet.traversal((Set.Visitor<Integer>) visitor);

        
    }
}