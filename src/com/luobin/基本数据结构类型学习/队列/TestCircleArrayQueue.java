package com.luobin.基本数据结构类型学习.队列;

import java.util.Scanner;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/3 3:44 下午
 */
public class TestCircleArrayQueue {
    public static void main(String[] args) {
        System.out.println("对于环形队列的测试代码");
        // 对于队列进行测试
        // 创建一个队列
        // 4 是最大的空间，只能存储两个数据，因为预留了一个空的位置
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' '; // 用于用户的出入操作
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("\ns(show) : 显示队列");
            System.out.println("e(exit) : 退出程序");
            System.out.println("a(add) : 添加数据到队列");
            System.out.println("g(get) : 从队列取出数据");
            System.out.println("h(head) : 查看队列的头数据");

            System.out.println("Input a char: ");
            key = scanner.next().charAt(0); // 接收一个字符

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {
                        // 获取到前面写的提示，数据是空的，不能获取到
                        System.out.println(e.getMessage());
                    }
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头部的数据是：%d\n", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close(); // 关闭输入
                    loop = false;    // 退出
                default:
                    break;
            }
        }
        System.out.println("程序退出～～");
    }
}
