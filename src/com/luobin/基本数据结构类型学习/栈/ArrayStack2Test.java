package com.luobin.基本数据结构类型学习.栈;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/7 7:37 下午
 */
public class ArrayStack2Test {
    public static void main(String[] args) {
        // 完成表达式的相关运算
        String express = "1+1+1+3*2";

        // 创建两个栈 符号栈以及 数字栈
        ArrayStack2 numStack = new ArrayStack2(100);
        ArrayStack2 operStack = new ArrayStack2(100);

        // 定义需要的相关变量
        int index = 0; // 用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描到的 char 进行保存

        // 开始用while 进行循环
        while (true) {
            // 依次得到expression 字符串
            // 取出一个字符串，字符串中的排序从 0 开始进行索引
            ch = express.substring(index, index + 1).charAt(0);

            // 判断进行处理
            if (operStack.isOper(ch)) {
                // 判断当前的符号是否是空的
                if (!operStack.isEmpty()) { // 这句话的意思是 符号栈中的符号不是空的，已经存在相关的符号了
                    // 符号栈存在操作符号，进行比较，当前的操作符优先级小于或者等于栈中的操作符，
                    // 从数字栈中取出两个数字（pop）
                    // 进行运算，得到结果，将计算结果放到栈中，然后把当前的操作符进行入栈操作
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calculate(num1, num2, oper);

                        // 将运算的结果入栈
                        numStack.push(res);

                        // 当前的符号入栈
                        operStack.push(ch);
                    } else {
                        // 如果运算符号的优先级别大于存在的操作符，直接入栈即可
                        operStack.push(ch);
                    }

                } else { // 是数字的，直接进入数字栈即可
                    // 因为在 ASCLL 中字符 '1' 对应的ASCLL 为49 想要得到数字 1 需要减去48
                    operStack.push(ch);
                }
            } else {
                numStack.push(ch - 48);
            }

            // 使得 index + 1 ，判断是否扫描到 expression  的最后面
            index++;
            // index 从 0 开始进行扫描 扫到字符串的长度的时候，刚好运行到字符串的最后面 所以是等于
            if (index >= express.length()) { // 到达最后的位置
                break;
            }
        }

        // 表达式扫描完毕，都放到了合适的位置的时候， 顺序取出来相应的数字以及符号，运行
        while (true) {
            // 如果符号栈是空的，计算得到最后的结果，数栈中只存储一个数字
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calculate(num1, num2, oper);
            numStack.push(res);
        }
        // 最后将计算得到的结果进行出栈
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d ", express, res2);
    }
}