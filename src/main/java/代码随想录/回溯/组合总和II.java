package 代码随想录.回溯;

import java.util.*;

public class 组合总和II {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    HashSet<Integer> hashSet = new HashSet<>();
    boolean[] used;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        //将所有值变成false
        // 加标志数组，用来辅助判断同层节点是否已经遍历

        Arrays.sort(candidates);
        backTracking(candidates,target,0,0);
        return result;
    }

    private void backTracking(int[] candidates,int targetSum, int startIndex, int sum) {
        if(targetSum==sum){
            result.add(new ArrayList<>(path));
            return;
        }

        int count=0;
        for (int i = startIndex; i <=candidates.length ; i++) {
            if(sum>targetSum){
                return;
            }
            /*
            if(hashMap.containsKey(candidates[i])){
                continue;
            }*/
            //这是树层上的去重逻辑
            //1.用hashmap可以，但是没必要，我们可以双指针直接用,额外做一个判断i>0
            //2.为什么这里有个used[i-1]的逻辑，是因为你不能见到相同元素就过，你要确定是数层的相同元素，不是树枝相同
            if(i>0&&candidates[i-1]==candidates[i] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            sum+=candidates[i];;
            path.add(candidates[i]);
            backTracking(candidates,targetSum,i+1,sum);
            used[i] = false;
            sum-=candidates[i];;
            path.removeLast();
        }
    }


}
