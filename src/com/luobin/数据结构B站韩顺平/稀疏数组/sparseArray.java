package com.luobin.数据结构B站韩顺平.稀疏数组;

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/7/31 7:09 下午
 */
public class sparseArray {
    // sparseArray 叫做稀疏数组的意思

    public static void main(String[] args) {
        // 创建原始的二维数组
        // 0 表示没有棋子， 1 表示黑色 2 表示蓝色
        // 创建十一行，十一列的数组
        // 创建存放棋子的棋盘
        int[][] chessArr1 = new int[11][11];

        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[6][6] = 2;

        // 对于二维数组进行输出

        System.out.println("原始的二维数组如下所示：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                // \t 相当于 tab
                System.out.printf("%d\t", data);
            }
            // 一行输出结束之后，进行换行输出
            System.out.println();
        }

        // 将二维数组转换成为稀疏数组
        // 1、对二维的数组进行遍历， 得到非 0 数据的个数
        int sum = 0;
        for (int[] ints : chessArr1) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }

//        System.out.println("非 0 的个数 Sum = " + sum);

        // 2、创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组进行赋值操作
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 对二维数组进行遍历，非 0 的数值存放到 sparseArr 中
        int count = 0; // 用来记录这是第几个非 0 数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {

                if (chessArr1[i][j] != 0) {
                    // count 代表的是稀疏数组中的记录元素的个数
                    count++;
                    // 建立的稀疏数组，数组中的每一个元素，存放相关的数据的行数，列数以及对应的数值
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 将稀疏数组进行输出
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        // 将稀疏矩阵进行原来矩阵的恢复
        /*
            第一步：先读取稀疏数组的第一行，进行数组大小的获取
            第二步：将稀疏矩阵的最后几行数据，进行赋值给原始的二维数组
         */
        // 将数组的大小进行获取
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        System.out.println("======");

        for (int i = 1; i < sparseArr.length; i++) {
            // chessArr2[][]  中的行以及列从 稀疏数组中进行获取 sparseArr[i][0]（获取到行）后面的获取到列
            // 值从稀疏数组中的第三列进行获取
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("下面是恢复后的二维数组：");

        // 将通过稀疏数组创建出来的数据进行输出，实现了元素的压缩以及解压
        for (int[] row : chessArr2) {
            for (int data : row) {
                // \t 相当于 tab
                System.out.printf("%d\t", data);
            }
            // 一行输出结束之后，进行换行输出
            System.out.println();
        }
    }
}