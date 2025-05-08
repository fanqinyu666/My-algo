package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.HashSet;

public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];

            if(!map.containsKey(j)){

                map.put(nums[i],i);
            }else {
                res[0]=i;
                res[1]=map.get(j);
            }

        }
        return res;
    }



}
