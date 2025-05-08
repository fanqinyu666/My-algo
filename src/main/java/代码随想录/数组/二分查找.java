package 代码随想录.数组;

import java.util.concurrent.ThreadPoolExecutor;

public class 二分查找 {

    public int search(int[] nums, int target) {
        int head=0;
        int tail=nums.length-1;
        while(head<=tail){
            int middle = head + (tail - head) / 2;
            if(nums[middle]==target){
                return middle;
            }
            if(nums[middle]>target){
                tail=middle-1;
            }
            if(nums[middle]<target){
                head=middle+1;
            }
        }
        return -1;
    }


}
