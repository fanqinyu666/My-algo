package 代码随想录.哈希表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set=new HashSet<Integer>();
        for (int num:nums) {
            num_set.add(num);
        }
        int result = 0;
        //这里主要用set，不是原数组，可能会重复
        for (int num:num_set) {
            if(num_set.contains(num-1)){
                continue;
            }
            int count=0;
            while(num_set.contains(num)){
                count++;
                num++;
            }
            result=Math.max(result,count);

        }
        return result;
    }

}
