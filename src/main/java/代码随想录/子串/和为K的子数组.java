package 代码随想录.子串;

import java.util.HashMap;

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
    //累加-k，看看有没有，有就累加
    public int subarraySum2(int[] nums, int k) {
        int pre=0;
        int count=0;
        HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
        //你0肯定有一个把，不然全错
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            //注意这里存入的是前缀，很容易忘记
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
