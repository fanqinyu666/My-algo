package 面试经典150.数组字符串;

import java.util.Arrays;

public class H指数 {

    public int hIndex(int[] citations) {
        int max=0;
        for (int i = 0; i < citations.length; i++) {
            max=Math.max(citations[i],max);
        }
        int[] dp = new int[max+1];
        for (int i = 0; i < citations.length; i++) {
            dp[citations[i]]++;
        }
        int res=1;
        for (int i = dp.length; i >=0 ; i--) {
            if(i<dp[i]){
                return res;
            }
            res++;
        }
        return res;
    }


}
