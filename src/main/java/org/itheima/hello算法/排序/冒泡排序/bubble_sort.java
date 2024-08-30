package org.itheima.hello算法.排序.冒泡排序;

public class bubble_sort {

    /* 冒泡排序 */
    void bubbleSort(int[] nums) {
        // 外循环：未排序区间为 [0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    /* 冒泡排序（标志优化） */
    void bubbleSortWithFlag(int[] nums) {
        // 外循环：未排序区间为 [0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false; // 初始化标志位
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true; // 记录交换元素
                }
            }
            //一轮循环无一个交换记录就结束
            if (!flag)
                break; // 此轮“冒泡”未交换任何元素，直接跳出
        }
    }
}
