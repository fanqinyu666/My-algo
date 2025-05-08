package 其他算法.其他.其他;

import java.util.Deque;
import java.util.LinkedList;

public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;

        while (left<right){

            int hight = Math.min(height[left], height[right]);
            int bound = right - left;
            max=Math.max(hight*bound,max);
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return max;
    }




}
