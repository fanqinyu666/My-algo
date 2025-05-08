package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 全排列II {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] booleans = new boolean[nums.length];
        Arrays.fill(booleans,false);
        Arrays.sort(nums);

        backtracking(nums,booleans);
        return result;
    }
    public void backtracking (int[] nums,boolean[] booleans){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0;i<nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && booleans[i - 1] == false) {
                continue;
            }
            if(booleans[i]==false) {
                booleans[i] = true;
                path.add(nums[i]);
                backtracking(nums, booleans);
                path.removeLast();
                booleans[i] = false;
            }
        }

    }


}
