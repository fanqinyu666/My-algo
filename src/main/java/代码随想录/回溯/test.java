package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

public class test {


    List<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> arrayList=new ArrayList<>();
    int total=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrant(k,n,1);
        return res;
    }

    private void backtrant(int k,int n,int index) {
        if(total==n&&arrayList.size()==k){
            res.add(new ArrayList<>(arrayList));
            return;
        }
        for(int i=index;i<9;i++){
            total+=i;
            arrayList.add(i);
            backtrant(k,n,i+1);
            arrayList.remove(arrayList.size()-1);
            total-=i;
        }
    }
}