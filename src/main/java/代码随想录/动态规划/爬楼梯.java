package 代码随想录.动态规划;

public class 爬楼梯 {


    public int climbStairs(int n) {
        if (n<=2) {
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i =3; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


}
