package 算法复习.复习1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//排序只是为了剪枝，
        backTracking(candidates,target,0,0);
        return result;
    }



    private void backTracking(int[] candidates, int targetSum,int num,int startindex){
        if(num>targetSum){
            return;
        }
        if(num==targetSum){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startindex; i < candidates.length; i++) {
            path.add(candidates[i]);
            num+=candidates[i];
            backTracking(candidates,targetSum,num,i);//这个比较特殊的是自己本身可有重复
            num-=candidates[i];
            path.removeLast();
        }
    }
}
