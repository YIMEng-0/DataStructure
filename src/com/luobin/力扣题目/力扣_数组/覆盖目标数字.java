package com.luobin.力扣题目.力扣_数组;

// https://leetcode-cn.com/problems/remove-element/
/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author Doraemon
 * @date 2021/11/26 8:21 上午
 * @version 1.0
 */
public class 覆盖目标数字 {
    public static void main(String[] args) {
        System.out.println("===快慢指针方法===");
        int[] testArray = {1, 2, 2, 3, 4};
        int numArr = deleteArrNum(testArray, 2);
        System.out.println("删除后数组中存在的元素个数为：" + numArr);

        System.out.println("===暴力破解===");
        int[] testArray1 = {1, 2, 2, 3, 4};
        int numArr1 = deleteNumByViolence(testArray1, 2);
        System.out.println("暴力破解后，数组中存在的元素为：" + numArr1);
    }

    /**
     * 使用快慢指针的方法删除数组中存在的目标数值
     * @param arr 待删除目标元素的数组
     * @param deleteNum 数组中需要删除的具体数值
     * @return 返回删除后数组中存在的元素个数
     */
    public static int deleteArrNum(int[] arr, int deleteNum) {
        int slow;
        int fast = 0;
        int[] newArray = new int[arr.length];

        for (slow = 0; fast < arr.length; fast++) {
            if (deleteNum != arr[fast]) {
                arr[slow] = arr[fast];
                slow++; // 返回出去刚好是数组中存在元素的个数，因为的最后一个数的索引加一了
            }
        }
        return slow;
    }

    /**
     * 使用暴力破解的方式进行元素的删除，因为存在的元素在内存中是连续存在的，所以在进行元素覆盖的时候，需要将元素进行整体的移动
     * @param arr 待删除元素的数组
     * @param deleteNum 数组中需要删除的元素
     * @return 删除后，数组中存在的元素
     */
    public static int deleteNumByViolence(int[] arr, int deleteNum) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            if (arr[i] == deleteNum) {
                for (int j = i + 1; j < size; j++) {
                    arr[j - 1] = arr[j];
                }
                i--;    // 数据删除之后，所有的数据向前移动一下，这个也是向前移动了一下，否则遍历不完全
                size--; // 数据删除之后，元素的数量减少了
            }
        }

        return size;
    }
}
