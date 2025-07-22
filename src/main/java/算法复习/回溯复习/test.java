package 算法复习.回溯复习;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] booleans;

    public List<List<Integer>> permuteUnique(int[] nums) {
        booleans=new boolean[nums.length];
        backtracking(nums,0);
        return res;
    }


    private void backtracking(int[] nums, int start) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i <nums.length; i++){
            //数层去重,这里booleans[i-1]是为了确保是数层去重，因为你是全排列，有可能取前面的元素
            //并且你有相同元素
            // 这种情况，假如112，11，就需要额外取判断
            if(i>0&&nums[i]==nums[i-1]&&booleans[i-1]) {
                continue;
            }
            if(booleans[i]){
                continue;
            }
            path.add(nums[i]);
            booleans[i]=true;
            backtracking(nums,start+1);
            booleans[i]=false;
            path.remove(path.size() - 1);
        }
    }

}
