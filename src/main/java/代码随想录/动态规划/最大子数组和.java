package 代码随想录.动态规划;

public class 最大子数组和 {

    //DP
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    //贪心
    public int maxSubArray2(int[] nums) {
        int sum=0,maxAns=nums[0];
        for(int x:nums){
            sum+=x;
            if(sum>maxAns) maxAns=sum;
            if(sum<0) sum=0;
        }
        return maxAns;
    }

}
