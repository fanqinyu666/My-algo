package 算法复习.复习1;

import org.itheima.hello数据结构.数组与链表.列表.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合 {

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrant(n,k,1);
        return res;
    }

    private void backtrant(int n,int k,int index) {
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrant(n,k,i+1);
            path.removeLast();
        }
    }

}
