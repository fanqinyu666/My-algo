package org.itheima.hello算法.动态规划.初探动态规划.记忆;

import java.util.Arrays;

public class climbing_stairs_dfs_mem {
    /* 记忆化搜索 */
    int dfs(int i, int[] mem) {
        // 已知 dp[1] 和 dp[2] ，返回之
        if (i == 1 || i == 2)
            return i;
        // 若存在记录 dp[i] ，则直接返回之
        if (mem[i] != -1)
            return mem[i];
        // dp[i] = dp[i-1] + dp[i-2]
        int count = dfs(i - 1, mem) + dfs(i - 2, mem);
        // 记录 dp[i]
        mem[i] = count;
        return count;
    }

    /* 爬楼梯：记忆化搜索 */
    int climbingStairsDFSMem(int n) {
        // mem[i] 记录爬到第 i 阶的方案总数，-1 代表无记录
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfs(n, mem);
    }
}
//直接从2的n优化到n
