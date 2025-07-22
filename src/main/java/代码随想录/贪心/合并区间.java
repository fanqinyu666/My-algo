package 代码随想录.贪心;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();

        Arrays.sort(intervals, (o1, o2)->Integer.compare(o1[0],o2[0]));
        res.add(intervals[0]);
        //先放入一个，之后放入的和现在放的作比较

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=res.get(res.size()-1)[1]){
                int[] remove = res.remove(res.size() - 1);
                remove[1]=Math.max(intervals[i][1], remove[1]);
                res.add(remove);

            }else{
                res.add(intervals[i]);
                //没有重叠放进来，不然合并
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}
