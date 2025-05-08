package 其他算法.其他.排序算法;

public class 归并排序 {
    void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j])
                tmp[k++] = nums[i++];
            else
                tmp[k++] = nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }
    void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2; // 计算中点
        mergeSort(nums, left, mid); // 递归左子数组
        mergeSort(nums, mid + 1, right); // 递归右子数组
        // 合并阶段
        merge(nums, left, mid, right);
    }
}
