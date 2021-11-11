package com.师兄推荐学习的数据结构与算法.树.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/11 9:18 下午
 */
public class BinaryTree {
    Node root;

    private Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.data) {
            // 使用了递归的方式进行了元素的插入，左子结点和右子结点是同样的处理方式
            current.left = addNode(current.left, value);
        } else if (value > current.data) {
            current.right = addNode(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    // 进行一个树的生成
    public BinaryTree createBinaryTree() {

        return null;
    }

    public void addNode(int value) {
        root = addNode(root, value);
    }

    /**
     * 进行结点的查找
     *
     * @param current
     * @param value
     * @return
     */
    private boolean containNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data ? containNode(current.left, value) : containNode(current.right, value);
    }

    public boolean containNode(int value) {
        return containNode(root, value);
    }

    /**
     * 删除一个结点
     *
     * @param current
     * @param value
     * @return
     */
    private Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteNode(current.right, smallestValue);
            return current;
        }
        if (value < current.data) {
            current.left = deleteNode(current.left, value);
            return current;
        }
        current.right = deleteNode(current.right, value);
        return current;
    }

    /**
     * 寻找树中最小的结点
     *
     * @param root
     * @return
     */
    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.right);
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void traversePreOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.println(root.data);
            traverseInOrder(root.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void traversePostOrder(Node root) {
        if (root != null) {
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public void traverseLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(node.data);
            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
