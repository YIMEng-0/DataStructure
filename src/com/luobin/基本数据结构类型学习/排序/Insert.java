package com.luobin.基本数据结构类型学习.排序;

/**
 * 插入排序是指在待排序的元素中，假设前面n-1(其中n>=2)个数已经是排好顺序的；
 * 现将第n个数插到前面已经排好的序列中，然后找到合适自己的位置，使得插入第n个数的这个序列也是排好顺序的；
 * 按照此法对所有元素进行插入，直到整个序列排为有序的过程，称为插入排序；
 */

public class Insert {
    public static void main(String[] args) {

        int[] testInsert = new int[]{0, 1, 2, 9, 3, 2, 1};
        insertSort(testInsert);
    }

    public static void insertSort(int[] arr) {
        int n = arr.length;
        int target;
        //从数组的第二个元素开始循环将数组中的元素插入
        for (int i = 1; i < n; i++) {
            int j = i;
            target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                //如果要播入的元素小于第j-1个元素,就将第j-1个元素向后移动
                arr[j] = arr[j - 1];
                j--;
            }
            //直到要插入的元素不小于第j-1个元素,将target插入到数组中
            arr[j] = target;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}