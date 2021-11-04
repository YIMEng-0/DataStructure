package com.luobin.数据结构B站韩顺平.队列;

import java.util.Scanner;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/2 9:22 下午
 */
public class TestQueue {
    public static void main(String[] args) {
        // 对于队列进行测试
        // 创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; // 用于用户的出入操作
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("s(show) : 显示队列");
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
                        System.out.printf("取出的数据是：%d", res);
                    } catch (Exception e) {
                        // 获取到前面写的提示，数据是空的，不能获取到
                        System.out.println(e.getMessage());
                    }
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头部的数据是：%d", res);

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
