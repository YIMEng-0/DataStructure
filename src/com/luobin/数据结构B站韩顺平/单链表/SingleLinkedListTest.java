package com.luobin.数据结构B站韩顺平.单链表;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/3 7:21 下午
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {

        // 进行测试，首先进行创建节点
        HeroNode hero1 = new HeroNode(1, "宋  江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢  义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴  用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林  冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "张  三", "三  儿");
        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 进行加入
        // 此时的 add 没有考虑到相关的排进去排序的问题，顺序是可以乱的
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero5);
        //显示
        singleLinkedList.list();

        // 按照编号进行加入处理
        System.out.println("按照编号进行添加的结果如下所示：\n");
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero5);

        // 对于修改后的节点进行测试
        // 基于 no 的数据的修改
        HeroNode hero6 = new HeroNode(5, "李  四", "六  子");
        singleLinkedList.update(hero6);

        // 删除节点的操作测试
        singleLinkedList.del(3);
        singleLinkedList.list();

        // 测试求取的链表的长度
        // 静态的方法使用类进行调用
        System.out.println("获取到的链表的节点的个数是：" + SingleLinkedList.getLength(singleLinkedList.getHead()) + "\n");

        // 找到链表中的倒数第一个节点
        HeroNode res = singleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 2);
        // 对于找到的节点进行打印
        System.out.println("res: \n" + res);

    }
}