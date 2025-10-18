package 面试经典150.数组字符串;

public class 移除元素 {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right<nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
