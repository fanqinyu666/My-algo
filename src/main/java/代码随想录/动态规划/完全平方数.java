package 代码随想录.动态规划;

import java.util.Arrays;

public class 完全平方数 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j * j < i; j++) {
                dp[i] = Math.min(dp[j], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
