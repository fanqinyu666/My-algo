package 代码随想录.回溯;

import java.util.*;

public class 全排列 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] booleans;
    public List<List<Integer>> permute(int[] nums) {
        booleans =new boolean[nums.length];
        Arrays.fill(booleans,false);
        backtracking(nums,booleans);
        return result;
    }
    public void backtracking (int[] nums,boolean[] booleans){
        //还有一个递增去重在何处呢？
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0;i<nums.length; i++) {
            if(booleans[i]){
                continue;
            }
            booleans[i]=true;
            path.add(nums[i]);
            backtracking(nums,booleans);
            path.removeLast();
            booleans[i]=false;
        }
    }
}
