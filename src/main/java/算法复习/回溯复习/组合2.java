package 算法复习.回溯复习;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合2 {

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrant(n,k,1,0);
        return res;
    }

    private void backtrant(int n,int k,int index,int total) {
        if(path.size()==k) {
            if(total==n){
                res.add(new ArrayList<>(path));
            }

            return;
        }

        for (int i = index; i <= 9; i++) {
            path.add(i);
            total += i;
            backtrant(n,k,i+1,total);
            path.removeLast();
            total-=i;
        }
    }







}
