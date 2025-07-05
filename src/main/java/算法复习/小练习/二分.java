package 算法复习.小练习;

public class 二分 {

    public static void main(String[] args) {
        search(new int[]{4,5,6,7,1,2},4);
    }


    public static int search(int[] num, int target){
        int left=0;
        int right= num.length-1;

        while (left<right){
            if(num[right]< num[left]){
                left=(right+left)/2;
                continue;
            }
            if(num[left]< num[right]){
                right=(right+left)/2;
                continue;
            }
            if(num[left]== num[right]){
                break;
            }
        }
        int rot=left;
        left = 0;
        right = num.length - 1;
        if(target>= num[right]){
            right=rot-1;
        }else {
            left = rot + 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public boolean canPartition(int[] nums) {
        int num=0;
        for (int a:nums)num+=a;
        if(num%2==1)return false;
        int res = num / 2;
        int[] dp = new int[res+1];
        for (int i=0;i<nums.length;i++){
            for (int j=res;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if(dp[res]==res)return true;
        return false;
    }

    public int lastStoneWeightII(int[] stones) {
        int num=0;
        for (int a:stones)num+=a;
        int res = num / 2;
        int[] dp = new int[res + 1];
        for (int i=0;i<stones.length;i++){
            for (int j=res;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return num-dp[res]*2;
    }


    public int findTargetSumWays(int[] nums, int target) {
        int num=0;
        for (int a:nums)num+=a;
        if (Math.abs(target) > num) return 0;
        if ((target + num)%2==1)return 0;
        int res = (target + num)/2;
        int[] dp= new int[res + 1];
        dp[0]=1;
        for (int i=0;i<nums.length;i++){
            for (int j=res;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[res];
    }







}
