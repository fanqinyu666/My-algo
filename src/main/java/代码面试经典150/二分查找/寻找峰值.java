package 代码面试经典150.二分查找;

public class 寻找峰值 {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid]>nums[mid+1])right=mid;
            else left=mid+1;
        }
        return right;
    }


}
