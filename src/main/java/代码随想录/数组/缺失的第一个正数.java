package 代码随想录.数组;

import java.util.HashSet;

public class 缺失的第一个正数 {

    public static void main(String[] args) {
        缺失的第一个正数 s = new 缺失的第一个正数();
        s.firstMissingPositive(new int[]{-1,4,2,1,9,10});
    }
    public int firstMissingPositive(int[] nums) {
        for (int i=0;i<nums.length;i++){
            //nums[i]!=nums[nums[i]-1]是避免死循环，如果有两个1，就会相互一直交换
            while (0<nums[i]&&nums[i]<nums.length && nums[i]!=nums[nums[i]-1]){
                //交换
                int num = nums[i];
                nums[i]= nums[num-1];
                nums[num-1]=num;
            }
        }

        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

}
