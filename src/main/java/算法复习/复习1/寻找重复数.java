package 算法复习.复习1;

import java.util.HashMap;
import java.util.Map;

public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        int a=0,b=0;
        a=nums[a];
        b=nums[nums[b]];
        while(a!=b){
            a=nums[a];
            b=nums[nums[b]];
        }

        b=0;
        while(a!=b){
            a=nums[a];

            b=nums[b];
        }
        return a;
    }


    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int count=0;
        int num=0;
        for (Map.Entry entry: map.entrySet()){
            Integer value = (Integer) entry.getValue();
            if(value>num){
                count=(Integer) entry.getKey();
                num=(Integer)entry.getValue();
            }
        }
        return count;
    }

    public int singleNumber(int[] nums) {
        int result=0;
        for (int i = 0; i < nums.length; i++)result^=nums[i];
        return result;
    }




}
