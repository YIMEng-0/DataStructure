package com.师兄推荐学习的数据结构与算法浙大和网课.树.二叉树;

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

        bt.traversePreOrderSon(bt.root);

        System.out.println("=== 求解二叉树的高度 ===");
        int heightOfTree = bt.postOrderGetHeight(bt.root);
        System.out.println("二叉树的高度是：" + heightOfTree);

        System.out.println("=== 在二叉搜索树进行元素的查找 ===");
        Node findNode = bt.find(3, bt.root);
        System.out.println(findNode.data);
        System.out.println(findNode.left.data);
        System.out.println(findNode.right.data);

        // 使用了循环代替掉了递归，实现了程序效率的提升
        System.out.println("=== 在二叉搜索树使用 while 循环进行元素的查找 ===");
        Node findNode1 = bt.findWithWhile(3, bt.root);
        System.out.println(findNode1.data);
        System.out.println(findNode1.left.data);
        System.out.println(findNode1.right.data);

        System.out.println("===寻找树种拥有最大值的结点===");
        Node maxNumNode = bt.findMaxDataNode(bt.root);
        System.out.println(maxNumNode.data);

        System.out.println("===寻找树种拥有最小值的结点===");
        Node minNumNode = bt.findMinDataNode(bt.root);
        System.out.println(minNumNode.data);
    }
}