package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合问题 {
    //放在全局变量，可以让代码可读性变强
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
    public void backtracking(int n, int k,int startindex){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        //这里可以剪枝，
        for (int i = startindex;i <= n-(k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();//回溯的过程，
        }

    }
}
