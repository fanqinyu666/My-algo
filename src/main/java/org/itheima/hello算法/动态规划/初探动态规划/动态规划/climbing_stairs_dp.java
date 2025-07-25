package org.itheima.hello算法.动态规划.初探动态规划.动态规划;

public class climbing_stairs_dp {
    /* 爬楼梯：动态规划 */
    int climbingStairsDP(int n) {
        if (n == 1 || n == 2)
            return n;
        // 初始化 dp 表，用于存储子问题的解
        int[] dp = new int[n + 1];
        // 初始状态：预设最小子问题的解
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移：从较小子问题逐步求解较大子问题
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /* 爬楼梯：空间优化后的动态规划 */
    int climbingStairsDPComp(int n) {
        if (n == 1 || n == 2)
            return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
    //观察以上代码，由于省去了数组 dp 占用的空间，因此空间复杂度从 O(n)
    // 降至 O(1)在动态规划问题中，当前状态往往仅与前面有限个状态有关，这
    // 时我们可以只保留必要的状态，通过“降维”来节省内存空间。这种空间优化
    // 技巧被称为“滚动变量”或“滚动数组”。

    //回溯从上往下递归
    //动态规划从下往上迭代
    //递归有真栈空间
    //迭代要用数组
    //但迭代需要当前状态往往仅与前面有限个状态有关，这时我们可以只保留必要的状态，不用数组用变量
    //而迭代回溯从上往下无法使用变量
    //所以动态规划比回溯强在动态规划可用简化空间复杂度
    //这种空间优化技巧被称为“滚动变量”或“滚动数组”。




}
