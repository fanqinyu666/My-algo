package 代码随想录.动态规划;

public class 不同路径 {

    public int uniquePaths(int m, int n) {
        //2行3列，传入，下标从0开始
        int[][] dp=new int[m][n];
        //第一行第一列都只有一种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
