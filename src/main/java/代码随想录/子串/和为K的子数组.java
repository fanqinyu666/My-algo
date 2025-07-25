package 代码随想录.子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class 和为K的子数组 {
    //前缀和
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
