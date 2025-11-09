package 面试经典150.数组字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int left=1;
        int right=1;
        while (right<nums.length){
            if (nums[right]!=nums[left-1]) {
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

}