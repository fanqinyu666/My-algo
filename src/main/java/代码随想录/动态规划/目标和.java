package 代码随想录.动态规划;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 目标和 {

    int count = 0;

    public int findTargetSumWays2(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }


    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        //如果target的绝对值大于sum，那么是没有方案的
        if (Math.abs(target) > sum) return 0;
        //如果(target+sum)除以2的余数不为0，也是没有方案的
        if ((target + sum) % 2 == 1) return 0;

        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagSize];
    }


}
