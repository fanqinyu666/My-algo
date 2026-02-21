package 代码面试经典150.数组字符串;

public class 跳跃游戏II {

    public int jump2(int[] nums) {
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
    public int jump(int[] nums) {
        int left=0,right=0;
        int count=0;
        while (right<nums.length-1){
            //定义某一层最远的距离
            int far=0;
            //左区间到右区间
            for (int i=left;i<=right;i++){
                far= Math.max(far,nums[i]+i);
            }
            //左边界就是上一个最远的+1，太对的！
            left=right+1;
            right=far;
            count++;
        }
        return count;
    }
}

