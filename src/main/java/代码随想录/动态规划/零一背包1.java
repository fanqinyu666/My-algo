package 代码随想录.动态规划;

import java.util.Scanner;

public class 零一背包1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();//背包最大容量

        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; ++i) {
            weight[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; ++j) {
            value[j] = scanner.nextInt();
        }
        int[][] dp = new int[n][bagweight + 1];//4就是4，给他4个
        for (int j = weight[0]; j <= bagweight; j++) {
            dp[0][j] = value[0];
        }
        //就初始化了第一行，从weight[0]开始就是从第一个能存入背包的重量开始
        // 其他默认初始化为0就够了



        //第二行开始
        for (int i = 1; i < n; i++) {
            //第一列开始
            for (int j = 0; j <= bagweight; j++) {

                if (j < weight[i]) {
                    //背包+1<物品，放不进来新东西，价值是正上方的东西
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //否则正确求
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[n - 1][bagweight]);
    }
}
