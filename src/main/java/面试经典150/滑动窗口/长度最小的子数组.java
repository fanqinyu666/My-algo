package 面试经典150.滑动窗口;

public class 长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0,sum=0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            if(sum>target){
                min = Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }else{
                sum+=nums[right];
                right++;
            }
        }
        return min;
    }


}
