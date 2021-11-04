package com.luobin.数据结构B站韩顺平.单链表;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/3 11:09 下午
 */
// 创建SingleLinkedList 的单链表，进行任务的管理
public class SingleLinkedList {

    // 初始化一个头节点 ， 头节点不动 ， 不存放具体的数据
    private final HeroNode head = new HeroNode(0, "", "");

    /**
     * @param head 链表的头节点
     * @return 返回有效的节点的格式
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) { // 空链表的判断
            return 0;
        }

        int length = 0;

        // 定义一个辅助变量，进行遍历
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // private 进行获取即可
    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单项链表
    public void add(HeroNode heroNode) {
        // 当不考虑编号的顺序时候
        // 1、找到当前链表的最后节点
        // 2、将最后的节点的next 指向新的节点

        // 因为头节点不能动，需要辅助指针temp ,对于链表进行遍历
        // 此处的 head 指的是 存储对象的引用地址，是地址的传递，起到一定的指针的作用
        HeroNode temp = head;

        // 进行遍历链表的操作
        while (true) {
            if (temp.next == null) {
                break;
            }

            // 辅助指针没有到最后的时候，将其向后面进行移动
            // next 指的是 相关节点对应的下一个节点的存储位置
            temp = temp.next;
        }

        // 当退出最后的 while 循环时候，temp 指向了链表的最后面；
        // 将最后这个节点的 next 指向到新的节点 进行链接操作；
        temp.next = heroNode;
    }

    // 显示链表 进行遍历
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 头节点的位置不能移动，需要创建使用一个辅助变量进行遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断是否为最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);

            // 将temp 进行后移
            temp = temp.next;
        }
    }

    // 使用第二种添加方式，使用排名将英雄加入到指定的位置
    // 有了排名，添加失败，给出提示
    public void addByOrder(HeroNode heroNode) {
        // 头节点不能动，使用辅助指针进行处理
        // 单链表，找到的temp 是位于添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false; // flag 标志添加的位置是否存在，默认为 false

        while (true) { // 说明此时 temp 处于链表的后面
            if (temp.next == null) {
                break;
            }

            if (temp.next.no > heroNode.no) {// 位置找到，在temp 的后面进行插入
                break;
            } else if (temp.next.no == heroNode.no) { // 说明添加的heroNode 的编号已经存在
                flag = true; // 说明编号是存在的
                break;
            }

            temp = temp.next;// 后移，遍历当前的链表 后移的前提是，前面的位置都没有找到
        }

        if (flag) {
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入", heroNode.no);
        } else {
            // 插入到链表中，temp 的后面
            heroNode.next = temp.next;  // （ 原始的temp.next 是与下一个元素连接的 ）
            temp.next = heroNode;       // （此时的temp.next 重新向着下一个新的节点进行连接）
            // temp 充当的就是指针的作用
        }
    }

    // 通过节点的 no 进行位置的寻找，然后修改相关的内容
    // 修改节点的信息，根据 no 编号进行修改， no 不能修改
    // 使用 HeroNode 的no 进行修改
    public void update(HeroNode newHeroNode) {
        // 判断链表是否是空的
        if (head.next == null) {
            System.out.println("链表为空");
        }

        // 找到需要修改的节点,
        // 定义辅助的变量，指向头节点后面的节点，因为头节点不是空的，向下面进行寻找
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; // 已经遍历完链表
            }

            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据 flag 判断是否找到了需要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号等于 %d 的节点，不能修改", newHeroNode.no);
        }
    }

    // 获取链表的节点的个数
    // 头节点不进行统计即可

    // 对于节点的删除操作
    // hea的 保持不动，使用temp 进行辅助的操作，找到需要删除的前面一个节点
    // 使用 temp.next.no 和需要删除的节点的比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到需要删除的节点
        while (true) {
            if (temp.next == null) { //到达链表的最后
                break;
            }

            if (temp.next.no == no) { // 找到了需要删除的节点的前一个位置
                flag = true; // 表示一下
                break;
            }
            temp = temp.next;
        }

        // 判断 flag
        if (flag) {
            // 直接省去中间需要删除的节点，接过去，会有垃圾回收机制
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到需要删除的节点");
        }
    }

    // 对于单链表中的倒数第 K 个的节点
    // 1、写一个方法，接收 head 节点 ，接收一个索引 index
    // 2、将链表进行从头到尾部的遍历，得到链表的总长度
    // 3、得到size 之后，从链表的第一个进行遍历（size - index）个，可以得到
    // 4、找到返回节点，找不到返回空
    public HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {//不存在链表返回空
            return null;
        }

        // 第一次遍历得到链表的长度
        int size = getLength(head);

        // 第二次的遍历到 size - index 的位置，进行停止即可
        // 得到的就是倒数第 k 节点
        // 对于 index 的值进行判断，不能超过一定的范围
        if (index <= 0 || index > size) {
            return null;
        }

        // 定义辅助变量(指针)
        HeroNode cur = head.next;

        // for 循环定位到倒数的位置
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }

        // 将找到的节点进行返回
        return cur;
    }

//     但链表的反转，将链表的节点进行反转
//     先定义一个节点 reverseHead 初始化是一个 新的 HeroNode();
//     从头到为遍历原来的链表，每遍历一个节点，将其取出来，放在新的链表的最前面
//     使用原来链表的 head.next = reverseHead.next;
//     将单链表进行反转
//
//    public void reverseList(HeroNode head) {
//        // 如果链表为空，不需要进行反转
//        // 链表有一个节点，不需要进行反转
//        if (head.next == null || head.next.next == null) {
//            return; // 进行中断处理
//        }
//
//        // 定义辅助的指针，变量遍历原来的列表
//        HeroNode cur = head;
//
//        // 定义当前节点的下一个节点是空的,进行双指针的操作，此处的指针是一个对象，保存了对象的地址
//
//        // 指向了当前节点的下一个节点
//        HeroNode next = null;
//        HeroNode reverseHead = new HeroNode(0,"","");
//        // 前期的准备工作创建了两个指针，以及新的reverse 的头节点
//
//        // 遍历原来的链表，遍历结束放在 reverseHead 的前面
//        while (cur != null) {
//            next = cur.next; //暂时保存当前节点的下一个节点，后面进行使用
//            cur.next = reverseHead.next; // cur 的下一个节点放在新的链表的最前端；
//            reverseHead.next = cur;      /// 将cur 连接到新的链表上
//            cur = next; // 让 cur 进行后移
//        }
//        // 将head.next 指向 reverse.next ,实现链表的反转
//        head.next = reverseHead.next;
//    }
//
//    // 让最后一个元素的指向为 null
}