package 代码随想录.动态规划;

public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        // 创建一个动态规划数组 dp，初始值为 0
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum % 2 != 0) return false;
        int target=sum/2;



        int[] dp = new int[target+1];//背包

        for(int i = 0; i < nums.length; i++) {//先遍历物品
            for(int j = target; j >= nums[i]; j--) {
//倒叙遍历背包，j>=nums[i],原因是你小于物品重量，你物品都放不进去，遍历背包容量也没有意义了，肯定是0，倒叙是为了每个物品使用一次
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
            if(dp[target] == target)
                return true;
        }
        return dp[target] == target;
    }
}
