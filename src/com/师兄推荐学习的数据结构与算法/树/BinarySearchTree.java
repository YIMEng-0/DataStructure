package com.师兄推荐学习的数据结构与算法.树;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/25 11:42 上午
 */

/**
 * 二叉搜索树的原理：
 * 1、找到需要插入的元素的父节点
 * 2、将需要插入的节点进行插入即可
 */
public class BinarySearchTree<E> {
    // 创建在下面进行判断操作时候使用的比较器；
    private final Comparator<E> comparator;
    // 节点的根节点属性
    Node<E> root;

    BinarySearchTree left;
    BinarySearchTree right;

    // 节点的数目属性
    private int size;

    // 对于二叉树里面的比较器的赋值
    // 进行比较器的构造函数的创建
    // 外部的Comparator() 逆行的传递，比较元素的大小，实现二叉树的生成
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // 可能是不会进行比较器的传递的
    // 比如使用了 Integer 传过来，里面已经实现了比较的方法；
    public BinarySearchTree() {
        this(null);
    }

    // 对于二插搜索树进行前序遍历
    // 将根节点开始遍历
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    public void preorderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }

        System.out.println("前序遍历到的元素为：" + node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        // 当 size 是 0 的时候，就是空的，否则就不是空的；
        return size == 0;
    }

    public void clear() {

    }

    /**
     * if null == root
     * 在第一个位置进行元素的创建以及元素的连接即可
     * <p>
     * if null != root
     * 1、找到需要插入元素的父节点；
     * 2、创建新的节点
     * 3、parent.left = node ｜｜ parent.right = node
     * <p>
     * 遇到的插入的值已经在树中存在了，应该怎么处理？
     * 1、直接return
     * 2、使用了覆盖
     *
     * @param element 需要放进去的元素的值
     */
    public void add(E element) {
        elementNotNullCheck(element);
        if (null == root) {
            // 直接创建根节点即可，自动进行连接
            root = new Node<>(element, null);
            size++;
            return;
        } else {
            // 定义一个父节点,目的是与下面的联合使用，找到插入元素的饿父节点，方便元素的插入操作；
            Node<E> parent = root;
            // 为了找到父节点
            Node<E> node = root;
            int cmp = 0;

            // 定义循环，进行下面的循环，找到自己需要的东西
            while (node != null) { // 从头到尾进行遍历，找到一个合适的父节点的位置
                cmp = compare(node.element, element);

                // parent 变量是为了找出父节点，经过循环 node 在改变，parent 的位置也是在改变的
                // 两层理解：1、将parent 指向了 node ；2、将 node 的地址数值赋值给 parent 即可；
                parent = node; // 向左边和右边移动之前的元素就是父节点；// 从根节点进行了遍历，

                if (cmp > 0) {
                    node = node.right; // node 是中间变量，可以进行遍历操作，因为是树，所以进行左右的遍历
                } else if (cmp < 0) {
                    node = node.left;
                } else { // 剩下了返回值是 == 0 的；是相等的
                    // 为什么覆盖掉？
                    // 看着需求进行修改
                    node.element = element;
                    return;
                }
            }

            // 循环出来找到了父节点的位置；
            // 找到了父节点所在的位置，进行父节点下面的额元素的插入，到底是在左边还是右边
            Node<E> newNode = new Node<>(element, parent);
            if (cmp > 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            size++;
        }
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            try {
                throw new IllegalAccessException("element not be null!!!");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param e1
     * @param e2
     * @return 返回值等于 0；代表，两个元素 e1 和 e2 是相等的；
     * > 0, e1 > e2
     * < 0, e1 < e2
     */
    private int compare(E e1, E e2) {
        return (Integer) e1 - (Integer) e2;
    }

    // 在二叉树里面，需要对于一个节点进行维护，保证各个节点之间的连线的正确性
    private static class Node<E> {
        E element;
        Node<E> left; // 表示开辟了内存空间，至于是否存放相关的 Node 数据类型，看后面的程序的需要
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) { // element parent 才是必要的，其他的不是必要的，这两个元素是比较常用的
            this.element = element;
            this.parent = parent;
        }
    }
}