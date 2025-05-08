package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 四数相加 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int temp=nums1[i]+nums2[j];
                if(map.containsKey(temp)){
                    int i1 = map.get(temp);
                    map.put(temp,i1+1);
                }else{
                    map.put(temp,1);
                }

            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int temp=nums3[i]+nums4[j];
                if(map.containsKey(-temp)){
                    int i1 = map.get(-temp);
                    res=res+i1;
                }
            }
        }

        return res;
    }
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i:nums1) {
            for (int j:nums2) {
                int temp=i+j;
                map.put(temp, map.getOrDefault(temp,0)+1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
    public int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int temp=nums1[i]+nums2[j];
                if(map.containsKey(temp)){
                    int i1 = map.get(temp);
                    map.put(temp,i1+1);
                }else{
                    map.put(temp,1);
                }

            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int temp=nums3[i]+nums4[j];
                if(map.containsKey(-temp)){
                    int i1 = map.get(-temp);
                    res=res+i1;
                }
            }
        }

        return res;
    }
}
