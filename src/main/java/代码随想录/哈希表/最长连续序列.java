package 代码随想录.哈希表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {
        int max=0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }


        for (int num:nums) {

            if(!set.contains(num)){
                set.add(num);
            }
            int count=0;
            int cur=num;
            while(set.contains(cur-1)){
                count++;
                cur--;
            }
            max=Math.max(max,count);
        }
    return max;
    }

}
