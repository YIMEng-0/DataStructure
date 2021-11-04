package com.luobin.数据结构B站韩顺平.队列;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/3 3:38 下午
 */
public class CircleArrayQueue {
    private int maxSize; // 队列的最大值
    private int front;   // 初始值为 0
    private int rear;    // rear 指向队列的最后一个元素的后一个位置 ，中间空下一个，使用

    private int[] arr;// 用于存放数据

    // 创建队列的构造器
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; // 指向队列的头部
        rear = 0;  // 指向队列的尾部，刚开始头部和尾部是重合的
    }

    public CircleArrayQueue() {
    }

    // 判断队列是否是满的
    public boolean isFull() {
        // 此处的判断是否为满的条件，比较特殊
        // rear 后面的有一个是空的
        return (rear + 1) % maxSize == front;
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

        // 直接将数据加入
        arr[rear] = n;
        // 将 rear 进行后移的操作，使用了取模，使得，数据可以进行循环存放，前面有了空位置之后
        // rear 是可以无限大的，但是存放的数据一直在循环
        rear = (rear + 1) % maxSize;
    }

    // 获取队列中的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            // 通过抛出异常进行控制
            throw new RuntimeException("队列为空，不能取出数据");
        }

        // 需要分析 front 是指向队列的第一个元素
        // 1、把 front 保存到临时变量
        // 2、将front 后移，front 不能无休止的向后移动，使用取模，控制在环形的队列中
        // 3、将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

        /*
             为什么不能写成

                return arr[front];
                front = (front+1) % maxSize;
                这种语句不成立，因为 return 之后的代码不会执行

                写成
                front++;
                return arr[front];
                没有考虑，环形队列的问题，不成立

                写成
                front = (front + 1) % maxSize;
                return arr[front];
                返回的不是第一个元素，不成立

                综上，写成上面的形式
         */
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }


        //从 front 进行遍历，遍历 size() 停止
        for (int i = front; i < front + size(); i++) {
            // i 变成 i % maxSize ，控制不要超过了队列的大小
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    // 求出当前队列中的存在的数据，否则无法完成遍历的功能
    public int size() {
        // rear = 1
        // front = 0
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }


    // 显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据");
        }
//        return arr[front + 1];
        // 此处的front 代表的是队列的第一个元素，以前是 -1 开始，现在是 0 开始，不需要进行 +1 的操作
        return arr[front];
    }


}
