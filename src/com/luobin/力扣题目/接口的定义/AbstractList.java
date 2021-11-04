package com.luobin.力扣题目.接口的定义;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/9/3 4:18 下午
 * <p>
 * 业务实现逻辑：
 * ArrayList 和 LinkedList 都继承了抽象类 AbstractList ，
 * 而 AbstractList 实现了 List 接口，由于本身为抽象类，不需要实现接口中的全部类，实现部分即可，其余的交给子类进行实现，
 * 这样设计，可以减少代码的重复，实现了代码的多次使用；
 * <p>
 * 业务实现逻辑：
 * ArrayList 和 LinkedList 都继承了抽象类 AbstractList ，
 * 而 AbstractList 实现了 List 接口，由于本身为抽象类，不需要实现接口中的全部类，实现部分即可，其余的交给子类进行实现，
 * 这样设计，可以减少代码的重复，实现了代码的多次使用；
 * <p>
 * 业务实现逻辑：
 * ArrayList 和 LinkedList 都继承了抽象类 AbstractList ，
 * 而 AbstractList 实现了 List 接口，由于本身为抽象类，不需要实现接口中的全部类，实现部分即可，其余的交给子类进行实现，
 * 这样设计，可以减少代码的重复，实现了代码的多次使用；
 */

// 定义抽象线性表
// 将动态数组和链表之间的具有相同功能的代码进行抽象
// 抽象类本身是不能创建对象的，符合设计思想
// 只负责抽取公共的代码，不对外公开

/**
 * 业务实现逻辑：
 * ArrayList 和 LinkedList 都继承了抽象类 AbstractList ，
 * 而 AbstractList 实现了 List 接口，由于本身为抽象类，不需要实现接口中的全部类，实现部分即可，其余的交给子类进行实现，
 * 这样设计，可以减少代码的重复，实现了代码的多次使用；
 */

/**
 * 此处的抽象类，可以对于接口中的部分功能进行实现，也可以只进行方法的声明
 */
public abstract class AbstractList<E> implements List<E> {
    private int size;

    // protected 是只有子类可以使用，同一个类，同一个包的类可以调用
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index >= 10) {
            outOfBound(index);
        }
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= 10) {
            outOfBound(index);
        }
    }

    private void outOfBound(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ",Size" + size);
    }

    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }
}