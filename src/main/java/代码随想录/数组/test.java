package 代码随想录.数组;

public class test {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0&&nums[i] > nums[i + 1])i--;
        int right = nums.length - 1;
        if (i>= 0) {
            while (right >= 0 && nums[i] >= nums[right]) {
                right--;
            }
            swap(nums, i, right);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}