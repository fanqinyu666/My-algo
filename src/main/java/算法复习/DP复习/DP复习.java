package 算法复习.DP复习;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DP复习{

    public int fib(int n) {
        if(n<1)return 0;
        int[] ints = new int[n+1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[ints.length - 1];
    }

    public int climbStairs(int n) {
        if(n<2)return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i< dp.length; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[dp.length-1];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i =0 ; i <m; i++) dp[i][0] = 1;
        for (int i =0 ; i <n; i++) dp[0][i] = 1;

        for (int i = 1; i <m; i++) {
            for (int j = 1; j <n; j++) {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        int[][] dp = new int[m][n];

        //居然这俩有问题,不好意思，n写成m了，我的问题
        for (int i =0 ; i <m; i++){
            if(obstacleGrid[i][0]==1)break;
            dp[i][0]=1;
        }
        for (int i =0 ; i <n; i++){
            if(obstacleGrid[0][i]==1)break;
            dp[0][i]=1;
        }

        for (int i = 1; i <n; i++){
            for (int j = 1; j <m; j++){
                if(obstacleGrid[j][i]==1)continue;
                dp[j][i]=dp[j-1][i]+dp[j][i-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int integerBreak(int n) {
        if(n<2)return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j <i; j++) {
                //这里带有贪心的思路，dp【i-j】一定是上一个拆分的最大值
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }



    public int numTrees(int n) {
        if(n<2)return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    boolean ok=false;
    int res=0;
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            res+=nums[i];
        }
        if(res%2==1){
            return false;
        }
        res = res / 2;
        trant(nums,0,0);
        return ok;
    }

    public int trant(int[] nums,int mid,int start){
        if(res==mid){
            ok=true;
            return 0;
        }
        if(mid>res)return 0;
        for(int i=start;i<nums.length;i++){

            trant(nums, mid+nums[i],i+1);

        }
        return res;
    }


    public boolean canPartitio2(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2==1) return false;
        sum =sum/2;
        int[] dp = new int[sum+1];
        for(int i = 0; i < nums.length; i++) {
            //先遍历物品
            for(int j=sum;j>=nums[i];j--){

                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
                if(sum==dp[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //贪心，有一些例子跑不通
    public int lastStoneWeightII2(int[] stones) {
        Arrays.sort(stones);
        int j=0;
        for (int i=stones.length-1;;) {
            j++;
            int i1 = stones[i] - stones[i - 1];
            if(i1==0){
                stones[i]=0;
                stones[i-1]=0;
            }
            if(i1>0) {
                stones[i]=0;
                stones[i-1]=i1;
            }
            Arrays.sort(stones);
            if(j==stones.length-1){
                break;
            }
        }
        return stones[stones.length-1];
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone:stones)sum+=stone;
        int total = sum/2;
        int[] dp = new int[total +1];
        for(int i=0;i<stones.length;i++){
            for(int j = total; j>=stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]]+stones[i]);
            }
        }
        return sum - 2 * dp[total];
    }




    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) sum += nums[i];

        if (Math.abs(target) > sum) return 0;
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


    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int x,y;
        for (String s:strs) {
            x=0;
            y=0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '0')x++;
                else y++;
            }
            for (int i=m; i>=x; i--) {
                for (int j = n; j >= y; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-x][j-y]+1);
                }
            }
        }
        return dp[m][n];
    }


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j<dp.length; j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }


    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <nums.length; j++) {
                if(i>=nums[j]) {
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE-1;
        int[] dp = new int[amount + 1];
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public int numSquares(int n) {
        int[] dp= new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;

        for (int i = 1; i*i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        //背包
        for (int i = 1; i < dp.length; i++) {
            //物品
            for (int j=0; j<i; j++) {
                if(set.contains(s.substring(j,i))&&dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[dp.length-1];

    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            nums2[i-1] = nums[i];
        }

        return Math.max(rob(nums1), rob(nums2));
    }


    public int rob(TreeNode root) {
        int[] dp;
        dp = backtracking(root);
        return Math.max(dp[0],dp[1]);    
    }
    
    public int[] backtracking(TreeNode root) {
        if(root==null) return new int[2];

        int[] dp = new int[2];
        int[] dp1 = backtracking(root.left);
        int[] dp2 = backtracking(root.right);

        dp[0]=Math.max(dp1[0],dp1[1])+Math.max(dp2[0],dp2[1]);
        dp[1] = root.val + dp1[0] + dp2[0];
        return dp;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]= Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }


    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][5];
        dp[0][0]=0;
        dp[0][1] = -prices[0];
        dp[0][2]=0;
        dp[0][3] = -prices[0];
        dp[0][4] =0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1]= Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]= Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]= Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]= Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return Math.max(dp[prices.length-1][2],dp[prices.length-1][4]);
    }


    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][1+k*2];
        for (int j = 1; j <= 2*k; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <2*k+1; j++) {
                if(j%2==1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j-1] - prices[i]);
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j-1] + prices[i]);
                }
            }
        }

        int max=0;
        for (int i = 2; i <=2*k; i+=2) {
            max=Math.max(max,dp[dp.length-1][i]);
        }
        return max;
    }


    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];

        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=0;
        dp[0][3]=0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(Math.max(dp[i-1][0],dp[i-1][3]-prices[i]),dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][3],dp[i-1][1]);
            dp[i][2]=dp[i-1][0]+prices[i];
            dp[i][3]=dp[i-1][2];
        }

        int max=0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, dp[prices.length - 1][i]);
        }

        return max;
    }


    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0]=-prices[0]-fee;
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max=0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max=0;
        for (int i = 1; i < dp.length; i++) {
            if(nums[i]>nums[i-1]) {
                dp[i]=dp[i-1]+1;
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }




    public int findLength(int[] nums1, int[] nums2) {
        //这里定义的[nums1.length+1][nums2.length+1];是为了多一层无效行和列，这样初始化全部初始化为0即可
        //不然需要定义很多
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int result=0;
        for(int i=1;i<nums1.length+1;i++) {
            for(int j=1;j<nums2.length+1;j++){
                if(nums1[i-1]==nums2[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {

                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i < nums1.length+1; i++) {
            for (int j = 1; j < nums2.length+1; j++) {

                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public int longestCommonSubseque2nce(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int max=0;
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;

    }

    public boolean isSubsequence(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length()+1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()]==s.length();
    }


    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }


    public static void main(String[] args) {
        DP复习 dp = new DP复习();
        dp.numDistinct("babgbag","bag");
    }


    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++) {
            dp[i][0] =i;
        }
        for (int j = 0; j < word2.length()+1; j++) {
            dp[0][j] =j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i][j-1]+1,dp[i-1][j]+1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++) dp[i][0] =i;
        for (int j = 0; j < word2.length()+1; j++) dp[0][j] =j;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j]);
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i][j])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public int countSubstrings(String s) {
        int result = 0;
        boolean[][] dp= new boolean[s.length()][s.length()];

        for (int i = s.length()-1; i >=0; i--) {
            for (int j=i; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }


    public int longestPalindromeSubseq(String s) {
        int result = 0;
        int[][] dp= new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = 1;

        for (int i = s.length()-1; i >=0; i--) {
            for (int j=i+1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }


    
}
