package 代码面试经典150.数组字符串;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int target=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=target){
                target=i;
            }
        }
        if(target==0)return true;
        return false;
    }
}
