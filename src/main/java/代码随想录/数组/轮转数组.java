package 代码随想录.数组;

import java.sql.Connection;
import java.util.Arrays;

public class 轮转数组 {
    //1.用一个数组里存变的，然后复制回去
    public void rotate(int[] nums, int k) {
        int right=k%nums.length;
        int[] res = new int[nums.length];
        for (int i=0;i<nums.length;i++)res[(i+right)%nums.length]=nums[i];
        for (int i=0;i<nums.length;i++)nums[i]=res[i];
    }
    //2.可以用一个环形链表，改变下标



    //3.O（1）空间解决，数学思维
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        //整体反转
        reverse(nums, 0, nums.length - 1);
        //下标K取余后，左右都反转一次
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
