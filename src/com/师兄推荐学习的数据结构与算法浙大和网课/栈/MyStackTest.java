package com.师兄推荐学习的数据结构与算法浙大和网课.栈;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/23 11:22 上午
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack);

        myStack.pop();
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
    }
}
