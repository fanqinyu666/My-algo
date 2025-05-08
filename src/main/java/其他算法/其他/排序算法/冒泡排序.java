package 其他算法.其他.排序算法;

public class 冒泡排序 {
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

    /* 冒泡排序 */
    void bubbleSort2(int[] nums) {

        for (int i = nums.length-1; i >0 ; i++) {
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
}
