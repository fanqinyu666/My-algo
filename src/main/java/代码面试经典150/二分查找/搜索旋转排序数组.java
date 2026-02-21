package 代码面试经典150.二分查找;

public class 搜索旋转排序数组 {

    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int rot = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[rot] && target <= nums[right]) {
            left = rot;
        } else {
            right = rot - 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
