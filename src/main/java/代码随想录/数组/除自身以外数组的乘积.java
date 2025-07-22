package 代码随想录.数组;

import java.util.Arrays;

public class 除自身以外数组的乘积 {
    //也是前缀和
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0]=1;
        r[nums.length-1]=1;
        for (int i=1;i<nums.length-1;i++){
            l[i]=l[i-1]*nums[i-1];
        }

        for (int i=nums.length-1;i>0;i--){
            r[i-1]=r[i]*nums[i];
        }
        int[] res = new int[nums.length];
        for (int i=0;i<res.length;i++){
            res[i]=l[i]*r[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }
        int L = 1;
        for(int i = 0; i < n; i++){
            ans[i] *= L;
            L *= nums[i];
        }
        int R = 1;
        for(int i = n - 1; i >= 0; i--){
            ans[i] *= R;
            R *= nums[i];
        }
        return ans;
    }
}
