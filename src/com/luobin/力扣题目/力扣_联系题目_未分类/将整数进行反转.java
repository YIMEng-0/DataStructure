package com.luobin.力扣题目.力扣_联系题目_未分类;

/**
 * @author Doraemon
 * @version 1.0
 * @Date 2021/10/15 9:25 上午
 */
public class 将整数进行反转 {
    public static final int MAX_NUM = 2147483647;
    public static final int MIN_NUM = -2147483647;

    public static void main(String[] args) {
        int res = reverse(1234567890);
//        System.out.println(Math.pow(2, 31)); 进行简单的数学运算
        System.out.println(res);
    }

    private static int reverse(int x) {
        //  返回值结果
        int res = 0;
        while (x != 0) {
            // 取到数字的最后一位
            int tmp = x % 10;

            // 判断是否溢出
            if (res > MAX_NUM || res == MAX_NUM && tmp > 7) {
                System.out.println("转换的数值溢出！！！");
                return 0;
            }

            if (res < MIN_NUM || res == MIN_NUM && tmp < -8) {
                System.out.println("转换的数值溢出！！！");
                return 0;
            }

//                res = tmp * 10 + res;  描述的错误
            // 向左边移动一个位置，乘法 * 10；
            // 每次对于 res 进行操作，操作的时候，将 res 的值进行放大， tmp 的值每次都充当个位数
            res = res * 10 + tmp;

            x = x / 10;
        }
        return res;
    }

    // 复制粘贴的标准答案；
    public static int reverseCopy(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
