package com.luobin.力扣数据结构练习题目.师兄推荐学习的数据结构与算法.树;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/10/20 6:08 下午
 */
public class BinarySearchTest02 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();


        // 将比较规则的比较器传入进去，创建的对象有了，相关的功能，有了类体中定义的方法，可以进行调用
        // 在 BinarySearchTree 中的比较器中，直接使用这里定义好的规则即可，只能比较Person 里面的年龄
        // 在这里可以使用 java 的匿名类，就是可以在构造参数中传入一个方法
        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());
        bst2.add(new Person(12));
        bst2.add(new Person(99));

        BinarySearchTree<Person> bst3 = new BinarySearchTree<>(new PersonComparator2());
        bst3.add(new Person(12));
        bst3.add(new Person(99));
    }


    // 大的减去小的，大的放在二叉树的右边
    // 定义大小比较器
    private static class PersonComparator implements Comparator<Person> {
        // compare(E e1,E e2) 是在接口中定义的，在继承的类中需要实现，
        // 创建的 PersonComparator 实现了Comparator ，在类体中实现了相关的方法；
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    // 小的减去大的，小的放在二叉树的右边
    // 创建的第二个 PersonComparator ，实现了比较的方法，方便了二叉树的形成；因为在二叉树形成的时候，需要进行元素的比较
    // 在这里可以拿到元素的比较结果
    private static class PersonComparator2 implements Comparator<Person> {
        // 调用方法的时候，传进去两个参数，通过创建的Person 类里面的年龄大小进行相关的比较操作；
        @Override
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }
}
