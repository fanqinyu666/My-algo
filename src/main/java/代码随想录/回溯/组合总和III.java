package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合总和III {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }
    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        if(k==path.size()){
            if(sum==targetSum){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <=9 ; i++) {
            sum+=i;
            path.add(i);
            backTracking(targetSum,k,i+1,sum);
            sum-=i;
            path.removeLast();
        }
    }

    //剪枝后的操作方法
    private void backTracking2(int targetSum, int k, int startIndex, int sum) {
        //1.剪枝操作，如果开始的值大于需要的值，直接回归
        if(startIndex>targetSum){
            return;
        }

        if(k==path.size()){
            if(sum==targetSum){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            //由于k=3，所以至少要有三个元素，一轮循环到7，7再找8，8再找9.刚好三个。所有超过7的可以剪枝了
            sum+=i;
            path.add(i);
            backTracking2(targetSum,k,i+1,sum);
            sum-=i;
            path.removeLast();
        }
    }


}
