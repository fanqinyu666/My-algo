package 算法复习.回溯复习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 阻塞总和2 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    private void backTracking(int[] candidates, int targetSum, int startIndex, int sum) {
        if (targetSum < sum) {
            //这里我粗心写反了
            return;
        }
        if (targetSum == sum) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex;i < candidates.length; i++) {

            if(i>startIndex&&candidates[i] == candidates[i-1]) {
                continue;
            }

            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, targetSum, i + 1, sum);
            //这里我用的是初始的index，两个问题
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
