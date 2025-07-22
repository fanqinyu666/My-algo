package 代码随想录.数组;

import java.util.HashMap;

public class 搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left<=right) {
            int mid =left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            //0-mid单调递增，mid在左侧大区间
            if (nums[0] <= nums[mid]) {
                //target是否在这块0-mid左侧小区间，不在就在mid-R
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //mid-right单调递增，在右侧大区间
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    //我自己思路的实现版本
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        // 第一步：找到旋转点（最小值位置）
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        int rot = left;
        // 第二步：确定搜索区间
        left = 0;
        right = nums.length - 1;
        if (target >= nums[rot] && target <= nums[right]) {
            left = rot;
        } else {
            right = rot - 1;
        }

        // 第三步：标准二分查找
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
