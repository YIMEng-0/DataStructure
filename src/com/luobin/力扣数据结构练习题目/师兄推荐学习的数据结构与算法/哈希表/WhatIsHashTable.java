package com.luobin.力扣数据结构练习题目.师兄推荐学习的数据结构与算法.哈希表;

/**
 * 1010101(不管之前的数字有多大，算出来的结果始终是小于 给定的数组大小 111 的)
 * &
 * 0000111
 * <p>
 * rs 0000101
 * <p>
 * 什么是良好的哈希函数？
 * 哈希函数可以让哈希值均匀的分布，减少了哈希冲突的次数，提升了哈希表的性能
 * <p>
 * 简单的原理理解：
 * 通过映射的键值对，将 key 进行传递进去，然后经过了哈希函数的处理，计算得到数组中的下标，使得进行索引的的时间复杂度是 O(1)
 * 通过了空间换时间；牺牲了空间，快速了时间
 * <p>
 * 哈希冲突：
 * 两个不同的key 但是最终的计算结果是相同的，哈希碰撞；
 * 解决办法：
 * 1、开放寻址法，进行空桶的探测，顺序的探测，跳转的探测；
 * 2、再哈希方法：另外的哈希算法实现；
 * 3、使用链表将桶子里面的值进行串起来；
 * <p>
 * Java 里面使用的单向链表解决哈希冲突，当哈希表的容量 >= 64 并且单项链表的节点数量 > 8 的时候，此时会把哈希表转换为红黑树，
 * 当红黑书的节点小于一定的数量时候，转换为单向链表；
 * 链表 + 红黄树？为什么使用？
 * 单链表：因为哈希冲突只是插入到链表的尾部，因为当元素的插入的时候，在链表上会进行元素的 key 的比较，相同的 key 存在的时候，
 * 覆盖掉，没有相同的 key ，追加到链表的尾部即可；
 * <p>
 * <p>
 * 哈希函数的作用：
 * 通过哈希函数将 key 传递进去，计算出来数组的下标
 * <p>
 * 哈希函数实现的大致步骤：
 * 1、使用key 生成哈希值（哈希值必须是使用整数）
 * 2、使用 key 的哈希值与数组的大小进行相关运算，生成一个索引值（因为最终数据是放在了数组元素中的，计算出来的哈希值是需要
 * 小于数组的索引的）
 * 比如使用下面的计算方式：
 * hashCode(key) % arr.length
 * 使用与运算（&） 取代 % （计算的速度比较慢，选择更加好的计算方式）运算的条件：数组的长度是 2^n
 * <p>
 * & 运算：
 * 1001010
 * &
 * 1101101
 * rs
 * 1001000(两个都是 1 的时候结果才是 1)
 * <p>
 * 为什么数组的长度是 2^n
 * 1 2^0
 * 10 2^1
 * 100 2^2
 * <p>
 * 1       2^1 - 1
 * 11      2^2 - 1
 * 111     2^3 - 1
 * 1111    2^4 - 1
 * <p>
 * <p>
 * 1001010
 * &
 * 1111111
 * rs
 * 1001010(是原来的key)(以前是什么，现在是什么)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 1010101(不管之前的数字有多大，算出来的结果始终是小于 给定的数组大小 111 的)
 * &
 * 0000111
 * <p>
 * rs 0000101
 * <p>
 * 什么是良好的哈希函数？
 * 哈希函数可以让哈希值均匀的分布，减少了哈希冲突的次数，提升了哈希表的性能
 * <p>
 * 简单的原理理解：
 * 通过映射的键值对，将 key 进行传递进去，然后经过了哈希函数的处理，计算得到数组中的下标，使得进行索引的的时间复杂度是 O(1)
 * 通过了空间换时间；牺牲了空间，快速了时间
 * <p>
 * 哈希冲突：
 * 两个不同的key 但是最终的计算结果是相同的，哈希碰撞；
 * 解决办法：
 * 1、开放寻址法，进行空桶的探测，顺序的探测，跳转的探测；
 * 2、再哈希方法：另外的哈希算法实现；
 * 3、使用链表将桶子里面的值进行串起来；
 * <p>
 * Java 里面使用的单向链表解决哈希冲突，当哈希表的容量 >= 64 并且单项链表的节点数量 > 8 的时候，此时会把哈希表转换为红黑树，
 * 当红黑书的节点小于一定的数量时候，转换为单向链表；
 * 链表 + 红黄树？为什么使用？
 * 单链表：因为哈希冲突只是插入到链表的尾部，因为当元素的插入的时候，在链表上会进行元素的 key 的比较，相同的 key 存在的时候，
 * 覆盖掉，没有相同的 key ，追加到链表的尾部即可；
 * <p>
 * <p>
 * 哈希函数的作用：
 * 通过哈希函数将 key 传递进去，计算出来数组的下标
 * <p>
 * 哈希函数实现的大致步骤：
 * 1、使用key 生成哈希值（哈希值必须是使用整数）
 * 2、使用 key 的哈希值与数组的大小进行相关运算，生成一个索引值（因为最终数据是放在了数组元素中的，计算出来的哈希值是需要
 * 小于数组的索引的）
 * 比如使用下面的计算方式：
 * hashCode(key) % arr.length
 * 使用与运算（&） 取代 % （计算的速度比较慢，选择更加好的计算方式）运算的条件：数组的长度是 2^n
 * <p>
 * & 运算：
 * 1001010
 * &
 * 1101101
 * rs
 * 1001000(两个都是 1 的时候结果才是 1)
 * <p>
 * 为什么数组的长度是 2^n
 * 1 2^0
 * 10 2^1
 * 100 2^2
 * <p>
 * 1       2^1 - 1
 * 11      2^2 - 1
 * 111     2^3 - 1
 * 1111    2^4 - 1
 * <p>
 * <p>
 * 1001010
 * &
 * 1111111
 * rs
 * 1001010(是原来的key)(以前是什么，现在是什么)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 1010101(不管之前的数字有多大，算出来的结果始终是小于 给定的数组大小 111 的)
 * &
 * 0000111
 * <p>
 * rs 0000101
 * <p>
 * 什么是良好的哈希函数？
 * 哈希函数可以让哈希值均匀的分布，减少了哈希冲突的次数，提升了哈希表的性能
 * <p>
 * 简单的原理理解：
 * 通过映射的键值对，将 key 进行传递进去，然后经过了哈希函数的处理，计算得到数组中的下标，使得进行索引的的时间复杂度是 O(1)
 * 通过了空间换时间；牺牲了空间，快速了时间
 * <p>
 * 哈希冲突：
 * 两个不同的key 但是最终的计算结果是相同的，哈希碰撞；
 * 解决办法：
 * 1、开放寻址法，进行空桶的探测，顺序的探测，跳转的探测；
 * 2、再哈希方法：另外的哈希算法实现；
 * 3、使用链表将桶子里面的值进行串起来；
 * <p>
 * Java 里面使用的单向链表解决哈希冲突，当哈希表的容量 >= 64 并且单项链表的节点数量 > 8 的时候，此时会把哈希表转换为红黑树，
 * 当红黑书的节点小于一定的数量时候，转换为单向链表；
 * 链表 + 红黄树？为什么使用？
 * 单链表：因为哈希冲突只是插入到链表的尾部，因为当元素的插入的时候，在链表上会进行元素的 key 的比较，相同的 key 存在的时候，
 * 覆盖掉，没有相同的 key ，追加到链表的尾部即可；
 * <p>
 * <p>
 * 哈希函数的作用：
 * 通过哈希函数将 key 传递进去，计算出来数组的下标
 * <p>
 * 哈希函数实现的大致步骤：
 * 1、使用key 生成哈希值（哈希值必须是使用整数）
 * 2、使用 key 的哈希值与数组的大小进行相关运算，生成一个索引值（因为最终数据是放在了数组元素中的，计算出来的哈希值是需要
 * 小于数组的索引的）
 * 比如使用下面的计算方式：
 * hashCode(key) % arr.length
 * 使用与运算（&） 取代 % （计算的速度比较慢，选择更加好的计算方式）运算的条件：数组的长度是 2^n
 * <p>
 * & 运算：
 * 1001010
 * &
 * 1101101
 * rs
 * 1001000(两个都是 1 的时候结果才是 1)
 * <p>
 * 为什么数组的长度是 2^n
 * 1 2^0
 * 10 2^1
 * 100 2^2
 * <p>
 * 1       2^1 - 1
 * 11      2^2 - 1
 * 111     2^3 - 1
 * 1111    2^4 - 1
 * <p>
 * <p>
 * 1001010
 * &
 * 1111111
 * rs
 * 1001010(是原来的key)(以前是什么，现在是什么)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 1010101(不管之前的数字有多大，算出来的结果始终是小于 给定的数组大小 111 的)
 * &
 * 0000111
 * <p>
 * rs 0000101
 * <p>
 * 什么是良好的哈希函数？
 * 哈希函数可以让哈希值均匀的分布，减少了哈希冲突的次数，提升了哈希表的性能
 */

/**
 * 简单的原理理解：
 * 通过映射的键值对，将 key 进行传递进去，然后经过了哈希函数的处理，计算得到数组中的下标，使得进行索引的的时间复杂度是 O(1)
 * 通过了空间换时间；牺牲了空间，快速了时间
 * <p>
 * 哈希冲突：
 * 两个不同的key 但是最终的计算结果是相同的，哈希碰撞；
 * 解决办法：
 * 1、开放寻址法，进行空桶的探测，顺序的探测，跳转的探测；
 * 2、再哈希方法：另外的哈希算法实现；
 * 3、使用链表将桶子里面的值进行串起来；
 * <p>
 * Java 里面使用的单向链表解决哈希冲突，当哈希表的容量 >= 64 并且单项链表的节点数量 > 8 的时候，此时会把哈希表转换为红黑树，
 * 当红黑书的节点小于一定的数量时候，转换为单向链表；
 * 链表 + 红黄树？为什么使用？
 * 单链表：因为哈希冲突只是插入到链表的尾部，因为当元素的插入的时候，在链表上会进行元素的 key 的比较，相同的 key 存在的时候，
 * 覆盖掉，没有相同的 key ，追加到链表的尾部即可；
 * <p>
 * <p>
 * 哈希函数的作用：
 * 通过哈希函数将 key 传递进去，计算出来数组的下标
 */

/**
 * 哈希函数实现的大致步骤：
 *      1、使用key 生成哈希值（哈希值必须是使用整数）
 *      2、使用 key 的哈希值与数组的大小进行相关运算，生成一个索引值（因为最终数据是放在了数组元素中的，计算出来的哈希值是需要
 *          小于数组的索引的）
 *          比如使用下面的计算方式：
 *              hashCode(key) % arr.length
 *              使用与运算（&） 取代 % （计算的速度比较慢，选择更加好的计算方式）运算的条件：数组的长度是 2^n
 */

/**
 * & 运算：
 * 1001010
 * &
 * 1101101
 * rs
 * 1001000(两个都是 1 的时候结果才是 1)
 *
 * 为什么数组的长度是 2^n
 *      1 2^0
 *      10 2^1
 *      100 2^2
 *
 *      1       2^1 - 1
 *      11      2^2 - 1
 *      111     2^3 - 1
 *      1111    2^4 - 1
 *
 *
 *      1001010
 * &
 *      1111111
 * rs
 *      1001010(是原来的key)(以前是什么，现在是什么)
 *
 *
 *
 *
 *
 *      1010101(不管之前的数字有多大，算出来的结果始终是小于 给定的数组大小 111 的)
 *     &
 *      0000111
 *
 *   rs 0000101
 */

/**
 * 什么是良好的哈希函数？
 *      哈希函数可以让哈希值均匀的分布，减少了哈希冲突的次数，提升了哈希表的性能
 */

/**
 * 如何生成 key 的哈希值？（哈希值为经过 key 生成的整数值）
 *      key 常见的种类：
 *      整数，浮点数，字符串，自定义对象
 *      对于不同种类的哈希值，哈希值生成的方式是不一样的，但是目标是一致的：
 *          1、尽量让所有的哈希值都是唯一的
 *          2、尽量让 key 所有的信息参与运算
 *
 *          整数：
 *              整数的哈希值是自己：10 的哈希值为10；
 *
 *          浮点数：
 *              将存储的二进制格式转换为整数值，最终获得的是 int 的整数值；
 *              所以浮点数调用 floatToIntBits() 函数即可，直接得到浮点数对应的二进制对应的整数；
 *              浮点数在计算机中的存储是二进制存储的，直接把二进制转换为整数类型，就是它的哈希值
 *
 *          long 64 位 java 中要求必须使用 32 为 int 进行整数的存储，所以需要处理
 *
 *
 */
public class WhatIsHashTable {
    public static void main(String[] args) {

        System.out.println(Float.floatToIntBits((float) 10.6));
        int code = Float.floatToIntBits((float) 10.6);
        // 返回浮点数对应的二进制整数计算出来 1000001001010011001100110011010
        // 同样的一串数字，在计算机中国表示的东西可能是不一样的，看是什么东西对它进行解释；
        // 1000001001010011001100110011010 浮点数的一个二进制表达，如果是十进制的话，数字很大了，解释的东西不一样

        int i = 10;
        System.out.println(31 * 10);
        System.out.println((i << 5) - i);
    }
}
