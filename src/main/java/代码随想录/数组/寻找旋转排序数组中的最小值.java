package 代码随想录.数组;

public class 寻找旋转排序数组中的最小值 {


    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        //没有终止条件，终止条件就是left=right时候。我们不是要找值，而是要筛选最小值
        while (left < right) {
            int mid = left + (right - left) / 2;
            //‌为什么left = mid + 1而right = mid‌：
            if (nums[mid] > nums[right]) {
                //当nums[mid] > nums[right]时，mid肯定不是最小值，所以可以跳过
                left = mid + 1;
            } else {
                //当nums[mid] <= nums[right]时，mid可能是最小值，不能跳过
                right = mid;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        寻找旋转排序数组中的最小值 s = new 寻找旋转排序数组中的最小值();
        s.findMin(new int[]{3,4,5,1,2});
    }
}
