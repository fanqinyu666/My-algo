package 代码随想录.贪心;

public class 跳跃游戏 {


    public boolean canJump(int[] nums) {
        int cover=0;
        if(nums.length==1){
            return true;
        }
        for (int i = 0; i <=cover; i++) {//关键重点  i<=cover
            cover=Math.max(cover,i+nums[i]);
            //更新覆盖范围
            if(cover>=nums.length-1){
                return true;
            }
        }
        return false;
    }










}
