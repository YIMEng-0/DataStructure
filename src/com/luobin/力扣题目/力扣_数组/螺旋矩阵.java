package com.luobin.力扣题目.力扣_数组;
//https://leetcode-cn.com/problems/spiral-matrix-ii/

/**
 * @author Doraemon
 * @date 2021/12/1 8:15 下午
 * @version 1.0
 */

public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] testArr = getSpiralMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(testArr[i][j]);
            }
        }
    }

    public static int[][] getSpiralMatrix(int n) {
        int startX = 0; // 定义螺旋矩阵的起始 X
        int startY = 0; // 定义螺旋矩阵的起始 Y
        int loop = n / 2; // 计算出来每一个圈需要循环的次数
        int mid = n / 2; // 奇数矩阵最终的元素的数值
        int count = 1; // 用来给矩阵中的每一个数值进行赋值，充当一个中间赋值的角色
        int offset = 1; // 控制每一圈的每一个边的长度
        int[][] res = new int[n][n];

        int i, j; // 定义一个在循环外面的变量，因为里面的每一个小循环出来的数值需要使用，不是小循环结束，i,j就不用了

        while (loop > 0) {
            i = startX;
            j = startY;

            // 下面的循环进行每一条边的赋值操作，边的赋值操作从上面，右边，下面，左边按照顺序是进行的；
            for (j = startY; j < startY + n - offset; j++) {
                res[startX][j] = count++;
            }

            for (i = startX; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }

            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            for (; i > startX; i--) {
                res[i][j] = count++;
            }
            loop--;
            // 进行第二圈的开始
            startX++;
            startY++;

            // 设置 offset 的数值。控制边的长度
            offset += 2;
        }

        // n 为奇数的判断
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
