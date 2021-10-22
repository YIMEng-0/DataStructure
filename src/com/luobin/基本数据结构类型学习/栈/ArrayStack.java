package com.luobin.基本数据结构类型学习.栈;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/7 6:40 下午
 */
public class ArrayStack {
    private final int maxSize; // 栈的大小的定义
    private final int[] stack; // 使用数组进行栈的模拟
    private int top = -1; // 表示栈底部，初始化的数值为 -1

    // 创建构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;        //
        stack = new int[this.maxSize]; // 需要对数组进行初始化，传入想要放进去的大小
    }

    // 栈满
    public boolean isFull() {
        // 两个等于好判断是否为真 或者 假
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");

            // 栈满的时候，结束该方法；break 在循环中结束；continue 在循环的这一次退出
            // return 一个是返回值；一个数结束当前的方法执行
            return;
        }

        // 栈顶部的东西向上加一，进行赋值即可
        top++;
        stack[top] = value;
    }

    // 出栈 pop--
    public int pop() {
        // 判断是否空,抛出运行异常
        if (isEmpty()) {
            throw new RuntimeException("栈满，没有数据");
        }

        int value = stack[top];
        top--;
        return value;
    }

    // 对栈进行遍历的操作
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
        }

        for (int i = 0; i <= top; i++) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }
}
