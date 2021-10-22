package com.luobin.基本数据结构类型学习.单链表;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/3 11:10 下午
 */
// 定义HeroNode, 使得每一个对象就是一个节点
public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;    // 指向下一个节点 创建的是一个对象，指向的是下一个对象的位置，进行遍历，让链表的对象与之相同，引用同一个对象，相当于一个指针

    // 创建类的构造器
    // 创建对象的时候，需要将相关的数据进行初始化
    public HeroNode(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    // 为了显示方法，重新进行 toString 方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no = " + no +
                ", name = " + name +
                ", nickname = " + nickname + "}";
    }
}