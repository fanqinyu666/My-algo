package 其他算法.其他.排序算法;

public class 选择排序 {


    /* 选择排序 */
    void selectionSort(int[] nums) {
        int n = nums.length;
        // 外循环：未排序区间为 [i, n-1]
        for (int i = 0; i < n - 1; i++) {
            // 内循环：找到未排序区间内的最小元素
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[k])
                    k = j; // 记录最小元素的索引
            }
            // 将该最小元素与未排序区间的首个元素交换
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
    /* 选择排序 */
    void selectionSort2(int[] nums) {


        for (int i = 0; i < nums.length-1; i++) {
            int index=0;
            int min=Integer.MAX_VALUE;
            for (int j = i+1; j < nums.length-1; j++) {
                if(min<nums[j]) {
                    index = j;
                }

            }
            int temp = nums[i];
            nums[i]=nums[index];
            nums[index]=temp;
        }

    }




}
