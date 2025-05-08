package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 子集 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums,int startindex) {
        res.add(new ArrayList<>(path));

        for (int i = startindex; i < nums.length; i++) {
            path.add(nums[i]);

            backTracking(nums, i+1);
            path.removeLast();
        }
        if(startindex==nums.length-1){
            return;
        }
    }

}
