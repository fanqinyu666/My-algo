package 代码随想录.哈希表;

import java.util.*;

public class 有效字母异味次 {


    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i)-'a']--;
        }

        for (int count:record) {
            if(count!=0){
                return false;
            }
        }
        return true;
    }



    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i <nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet();

        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        set.retainAll(set2);
        return set.stream().mapToInt(x -> x).toArray();
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        int[] hash1  = new int[1002];
        int[] hash2  = new int[1002];

        for (int i = 0; i < nums1.length; i++) {
            hash1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            hash2[nums2[i]]++;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < 1002; i++){
            if(hash1[i] > 0 && hash2[i] > 0) {
                arrayList.add(i);
            }
        }

        int index = 0;
        int res[] = new int[arrayList.size()];
        for(int i : arrayList)
            res[index++] = i;
        return res;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                Integer i1 = map.get(target - nums[i]);
                res[0]=i1;
                res[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }



}
