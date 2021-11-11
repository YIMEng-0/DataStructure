package com.师兄推荐学习的数据结构与算法.树.二叉树;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/11 9:25 下午
 */
public class BinaryTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(3);
        bt.addNode(4);
        bt.addNode(6);
        bt.addNode(1);
        bt.addNode(2);
        bt.addNode(8);
        bt.addNode(9);
        bt.addNode(7);


        bt.traversePreOrder(bt.root);
    }
}
