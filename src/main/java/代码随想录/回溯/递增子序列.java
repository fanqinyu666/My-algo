package 代码随想录.回溯;

import java.util.*;

public class 递增子序列 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    public void backtracking (int[] nums,int startindex){
        //还有一个递增去重在何处呢？
        if(path.size()>=2){
            result.add(new ArrayList<>(path));
        }
        if(startindex==nums.length){
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = startindex;i<nums.length; i++) {

            if(!path.isEmpty()&&path.getLast()>nums[i]||set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }

    }


}
