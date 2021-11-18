package com.师兄推荐学习的数据结构与算法浙大和网课.树.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/11 9:18 下午
 */
public class BinaryTree {
    // 所有的结点都是一个一个的 Node 进行组装而成的，中间使用链子记性连接即可
    Node root;

    private Node addNode(Node current, int value) {
        // 因为是 current.right 传进来了所以是Node490

        if (current == null) {
            // 空结点的时候，直接创建一个新的结点即可
            return new Node(value);
            // 关于在 return 后面为什么会继续执行下面的语句，因为先执行右边的语句，再执行左边的语句，右边的执行调用了这个if 这个if 里面有 return 但是看起来
            // return 执行结束后，程序会结束，但是人家左边还没有执行，所以先回到下面执行了左边的代码，再return 出去
        }
        if (value < current.data) {
            // 使用了递归的方式进行了元素的插入，左子结点和右子结点是同样的处理方式
            // Node489 的left 连接到 490 的左边
            // 左边的current.left 表示的是490, 进行了线的链接
            // 右边的 current.left 表示的是Node489 的左边此时还为 null
            // 经过了右边的结点的创建，左边的
            current.left = addNode(current.left, value);
        } else if (value > current.data) {
            // 使用当前结点的空的位置带进去创建了一个新的结点
            // 然后指向了新建结点，进行结点之间的链接
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
     * @param currentNode
     * @param value
     * @return
     */
    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (value == currentNode.data) {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            if (currentNode.left == null) {
                return currentNode.right;
            }
            if (currentNode.right == null) {
                return currentNode.left;
            }
            int smallestValue = findSmallestValue(currentNode.right);
            currentNode.data = smallestValue;
            currentNode.right = deleteNode(currentNode.right, smallestValue);
            return currentNode;
        }
        if (value < currentNode.data) {
            currentNode.left = deleteNode(currentNode.left, value);
            return currentNode;
        }
        currentNode.right = deleteNode(currentNode.right, value);
        return currentNode;
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
        if (root != null) {// 进行了叶子结点的打印
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
     * 只打印叶子结点，其他的不打印
     *
     * @param root
     */
    public void traversePreOrderSon(Node root) {
        if (root != null) {// 进行了叶子结点的打印
            if (root.left == null & root.right == null) {
                System.out.println("这个树里面的没有左右儿子叶子结点是：" + root.data);
            }
            traversePreOrderSon(root.left);
            traversePreOrderSon(root.right);
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
     * 使用了后序遍历进行树的高度的获取
     * 思想:树的高度是左右子树的最大高度 + 1
     *
     * @param root 将整棵树传递进去，也就是把树的根节点传递进去
     * @return
     */
    public int postOrderGetHeight(Node root) {
        int leftTreeHeight = 0;
        int rightTreeHeight = 0;
        int maxTreeHeight;

        if (root != null) {
            leftTreeHeight = postOrderGetHeight(root.left);
            rightTreeHeight = postOrderGetHeight(root.right);
            maxTreeHeight = (leftTreeHeight > rightTreeHeight) ? leftTreeHeight : rightTreeHeight;
            return (maxTreeHeight + 1);
        } else {
            return 0;
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

    /**
     * 实现二叉查找树，
     */

    public Node find(int x, Node currentNode) {
        if (currentNode == null) { // 空的树，查找失败了
            return null;
        }

        if (x > currentNode.data) { // 当前的数值大于当前结点
            return find(x, currentNode.right);
        } else if (x < currentNode.data) {
            return find(x, currentNode.left);
        }
        return currentNode; // 查找成功，返回找到的结点的地址，因为这是一个引用变量找到的是一个地址；
    }

    /**
     * 上面的二叉搜索使用了尾递归的方式，效率是比较差的，下面使用了循环进行优化
     * 二叉搜索树的效率和树的高度是存在密切的关系的；
     * 希望树看起来是比较平衡的
     */
    public Node findWithWhile(int x, Node currentNode) {
        while (currentNode != null) {
            if (x > currentNode.data) {
                currentNode = currentNode.right;
            } else if (x < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                return currentNode;
            }
        }
        return null;
    }


    /**
     * 使用递归实现寻找最大元素
     *
     * @param currentNode 将树的根节点进行传递进去
     * @return 拥有最大值的结点
     */
    public Node findMaxDataNode(Node currentNode) {
        if (currentNode == null) {
            return null;
        } else if (currentNode.right == null) {
            return currentNode;
        } else {
            return findMaxDataNode(currentNode.right);
        }
    }

    /**
     * 使用递归实现寻找树中的最小值元素
     *
     * @param currentNode 先传进去的是树的根结点
     * @return 找到拥有最小值的结点
     */
    public Node findMinDataNode(Node currentNode) {
        if (currentNode == null) { // 一般是根节点先传进来，这里为空，就是null 什么都没有
            return null;
        }
        if (currentNode.left == null) { // 找最小的元素，左边没有任何元素，根一定是最小的元素
            return currentNode;
        } else {
            return findMinDataNode(currentNode.left); // 进行下面的元素寻找，始终寻找最左边的元素
        }
    }
}