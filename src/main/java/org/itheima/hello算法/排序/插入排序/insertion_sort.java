package org.itheima.hello算法.排序.插入排序;

public class insertion_sort {
    /* 插入排序 */
    void insertionSort(int[] nums) {
        // 外循环：已排序区间为 [0, i-1]
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];//从下标为开始
            int j = i - 1;//从下标为0开始

            // 内循环：将 base 插入到已排序区间 [0, i-1] 中的正确位置
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j]; // 将 nums[j] 向右移动一位
                j--;
            }
            nums[j + 1] = base;        // 将 base 赋值到正确位置
        }
    }

    /* 插入排序 */
    void insertion(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];//从下标为开始
            int j = i - 1;//从下标为0开始
            while (j>=0&&nums[j]>base){
                nums[j + 1] = nums[j]; // 将 nums[j] 向右移动一位
                j--;
            }
            nums[j + 1] = base;        // 将 base 赋值到正确位置

        }
    }



}

