package 代码随想录.数组;

import java.util.HashMap;
import java.util.HashSet;

public class 盛最多水的容器 {


    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;

        while (left<right){
            int hight = Math.min(height[left], height[right]);
            int bound = right - left;
            max=Math.max(hight*bound,max);
            //肯定是移走小的，Math.min(height[left], height[right]);只和小的那个有关系
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return max;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            pre+=nums[i];
            if (map.containsKey(pre-k))count+=map.get(pre-k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
