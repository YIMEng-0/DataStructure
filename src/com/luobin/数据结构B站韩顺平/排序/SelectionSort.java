package com.luobin.数据结构B站韩顺平.排序;

// 优秀代码实现选择排序
// https://www.cnblogs.com/itall/p/12611509.html

/**
 * @author LuoBin
 * @version 1.0
 * @date 2021/8/9 1:34 下午
 */
//选择排序
// 第一次从待排序的数据元素中选出最小（或最大）的一个元素，
// 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾
// 以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 3, 2};
        System.out.println("排序之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // 选择排序的实现
        // 记录最小的元素
        // 外层循环控制，无序元素的个数，内层控制从无序中选出最小值
        for (int i = 0; i < arr.length; i++) {// 乱序中有 n 个元素
            int min = i;
            // 寻找小元素的位置，小就把它的位置记录下来
            for (int j = i + 1; j < arr.length; j++) { // 出来之后，选择了最小的元素
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            System.out.println("选择出的最小元素是：" + arr[min]);

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println();
        System.out.println("排序之后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
