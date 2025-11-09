package 面试经典150.数组字符串;

public class 跳跃游戏II {

    public int jump(int[] nums) {
        int left=0,right=0;
        int min=0;
        while (right<nums.length-1){
            int longest=0;
            for (int i = left; i <=right ; i++) {
                longest=Math.max(longest,i+nums[i]);
            }
            left=right+1;
            right=longest;
            min++;
        }
        return min;
    }
}

