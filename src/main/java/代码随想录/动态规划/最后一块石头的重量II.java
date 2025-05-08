package 代码随想录.动态规划;

public class 最后一块石头的重量II {

    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int stone:stones) {
            sum+=stone;
        }
        int target = sum / 2;

        int[] dp = new int[target+1];//背包

        for(int i = 0; i < stones.length; i++) {//先遍历物品
            for(int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
            if(dp[target] == target){
                return sum-dp[target]-dp[target];
            }
        }
        return sum-dp[target]-dp[target];
    }

}
