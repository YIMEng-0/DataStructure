package com.师兄推荐学习的数据结构与算法浙大和网课.树;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/25 2:02 下午
 */
public class BinarySearchTest {


    public static void main(String[] args) {
        Integer[] data = new Integer[]{
                9, 1, 3, 3, 4, 5, 6, 6, 4, 3, 3, 2, 1, 3
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        System.out.println("树的大小为：" + bst.size());
        bst.preorderTraversal();
        System.out.println("树的大小为：" + bst.size());
    }
}