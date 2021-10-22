package com.luobin.基本数据结构类型学习.单链表;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/3 11:29 下午
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();

        // 默认进行 输出对象的时候，会进行调用 toString 方法 ，使用了重写，可以输出对象的相关信息
        System.out.println(person);
        byte b = (byte) 129;
        System.out.println(b);
    }

}

class Person {
    private String name;
    private String email;

    // command + n 进行快速重写
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
/*
        运行结果：
        com.heima.bean.Student@15db9742

        运行结果表示：
        @左边表示的是类名，
        右边表示的hashCode值经过十六进制转换的结果
        下面我们继续看一下Object类的toString方法实现方式就一目了然了：

        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }

        getClass().getName表示获取运行类对象名称
        Integer.toHexString(hashCode())表示将hashCode()转换成十六进制的形式展出
        经过上述解释，发现这样调用toString展示结果没有什么用...，Object是所有类的父类，表示我们可以对toString进行重写。
 */
