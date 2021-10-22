package com.luobin.基本数据结构类型学习.队列;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/2 8:54 下午
 */
public class ArrayQueue {
    private final int maxSize; // 队列的最大值
    private final int[] arr;// 用于存放数据
    private int front;
    private int rear;

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列的头部
        rear = -1;  // 指向队列的尾部，刚开始头部和尾部是重合的
    }

    // 判断队列是否是满的
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 将数据添加到队列
    public void addQueue(int n) {
        // 判断是否是满的
        if (isFull()) {
            System.out.println("队列是满的，不能加入数据！");
        }

        rear++;     // 将标进行向后移动，添加数据
        arr[rear] = n;
    }

    // 获取队列中的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            // 通过抛出异常进行控制
            throw new RuntimeException("队列为空，不能取出数据");
        }

        front++; // front 后移，进行取出数据先进，先出的原则

        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }

    }

    // 显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front + 1];
    }
}
