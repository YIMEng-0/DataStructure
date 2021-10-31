package com.luobin.力扣数据结构练习题目.师兄推荐学习的数据结构与算法.树;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/25 2:02 下午
 */
public class BinarySearchTest01 {
    public static void main(String[] args) {
        Integer[] data = new Integer[]{
                9, 1, 3
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
    }
}