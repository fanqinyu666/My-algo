package 面试经典150.数组字符串;

public class 多数元素 {

    public int majorityElement(int[] nums) {
        int len=1;
        int cur=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(cur==nums[i]){
                len++;
                continue;
            }
            if(cur!=nums[i]){
                if(len==0){
                    len++;
                    cur=nums[i];
                }else len--;
            }
        }
        return cur;
    }
}
