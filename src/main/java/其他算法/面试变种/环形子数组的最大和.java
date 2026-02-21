package 其他算法.面试变种;


import java.util.Arrays;

public class 环形子数组的最大和 {
    //这道题和子数组和和很类似
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i=1;i<dp.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            if(dp[i]>max)max=dp[i];
        }
        int min=0;
        for (int i=1;i<nums.length-1;i++){
            dp[i]=Math.min(dp[i-1],0)+nums[i];
            if(dp[i]<min)min=dp[i];
        }
        int sum=0;

        for (int i=0;i<nums.length;i++)sum+=nums[i];
        return Math.max(max,sum-min);
    }


}
