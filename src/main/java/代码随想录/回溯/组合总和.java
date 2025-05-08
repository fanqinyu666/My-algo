package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backTracking(candidates,target,0,0);
        return result;
    }



    private void backTracking(int[] candidates, int targetSum,int num,int startindex) {
        if(num>targetSum){
            return;
        }
        if(num==targetSum){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startindex; i <candidates.length ; i++) {
            path.add(candidates[i]);
            backTracking(candidates,targetSum,num+candidates[i],i);
            path.removeLast();
        }
    }
}
