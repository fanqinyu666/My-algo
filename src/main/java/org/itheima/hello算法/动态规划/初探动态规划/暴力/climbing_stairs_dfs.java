package org.itheima.hello算法.动态规划.初探动态规划.暴力;

public class climbing_stairs_dfs {
    /* 搜索 */
    int dfs(int i) {
        // 已知 dp[1] 和 dp[2] ，返回之
        if (i == 1 || i == 2)
            return i;
        // dp[i] = dp[i-1] + dp[i-2]
        int count = dfs(i - 1) + dfs(i - 2);
        return count;
    }

    /* 爬楼梯：搜索 */
    int climbingStairsDFS(int n) {
        return dfs(n);
    }
}
