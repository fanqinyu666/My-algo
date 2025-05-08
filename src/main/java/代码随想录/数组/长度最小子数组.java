package 代码随想录.数组;

public class 长度最小子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count=Integer.MAX_VALUE;
        int sum=0;
        sum+=nums[0];
        for (int slow=0,fast=1; fast<nums.length; ) {
            if(sum>target){
                sum-=nums[slow];
                slow++;
            }else if(sum<target){
                sum+=nums[fast];
                fast++;
            }else {
                count=Math.min(count,fast-slow+1);
            }
        }

        return count;
    }

}
