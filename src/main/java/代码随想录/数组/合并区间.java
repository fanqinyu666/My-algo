package 代码随想录.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 合并区间 {
    //这也不是贪心啊，不就是普通数组题么
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        ArrayList<int[]> ints = new ArrayList<>();

        int count=intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i-1][0],intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
            if(intervals[i-1][1] < intervals[i][0]) {
                ints.add(intervals[i-1]);
            }
        }
        ints.add(intervals[intervals.length-1]);
        return ints.toArray(new int[ints.size()][]);
    }



}
