package com.luobin.数据结构B站韩顺平.栈;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/7 7:11 下午
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(6);

        // 进行入栈测试
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.list();
        System.out.println("\n");

        // 进行出栈测试
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.list();

    }
}
