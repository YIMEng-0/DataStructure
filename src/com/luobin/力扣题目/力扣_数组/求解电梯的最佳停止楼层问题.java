package com.luobin.力扣题目.力扣_数组;

/**
 * @author Doraemon
 * @date 2021/11/20 2:36 下午
 * @version 1.0
 */
public class 求解电梯的最佳停止楼层问题 {
    public static void main(String[] args) {
        // 测试的数据中，第一个位置为占位符号，是不放置任何数字的；
        // 第二个位置也是不存放数组的，为了数组的索引
        int null1 = 0, null2 = 0;
        int[] people = {null1, null2, 0, 0, 20, 0, 8};
        int bestFloor = findBestStopFloor(people);
        System.out.println("选择出来的最佳楼层为：" + bestFloor);
    }

    /**
     *
     * @param nPerson 到达每一层楼的人数
     * @return
     */
    public static int findBestStopFloor(int[] nPerson) {
        int nFloor, nMinFloor = 0, nTargetFloor = -1, N = 6;
        // N 目前大楼的高
        // 第一个循环控制的是假设电梯停留的楼层
        for (int i = 1; i <= N; i++) {
            nFloor = 0;

            // 第二个循环控制的是电梯在每个层都停留一定的时间
            for (int j = 1; j < i; j++) {
                nFloor += nPerson[j] * (i - j);
            }

            for (int j = i + 1; j <= N; j++) {
                nFloor += nPerson[j] * (j - i);
            }

            if (nTargetFloor == -1 || (nMinFloor > nFloor)) {
                nMinFloor = nFloor;
                nTargetFloor = i;
            }
        }

        return nTargetFloor;
    }
}