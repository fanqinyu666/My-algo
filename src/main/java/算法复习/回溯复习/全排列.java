package 算法复习.回溯复习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used=new boolean[nums.length];
        backtracking(nums,0);
        return result;
    }

    public void backtracking (int[] nums,int index) {
        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                //如果只写这个，我们做了一个数层去重，但是树枝也可能去重，
                continue;
            }
            if (used[i] == false) {
                //这里逻辑之前是上面写的，现在写下面了
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, index + 1);
                path.remove(path.size() - 1);
                used[i] = false;

            }
        }
    }
}
