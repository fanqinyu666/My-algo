package 代码随想录.贪心;

import java.util.Arrays;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)->Integer.compare(o1[0],o2[0]));

        int sum=0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<intervals[i-1][1]){
                sum+=1;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                //更新为有边界的最小值，将当前边界修改，下一个边界会和当前边界比较

            }
        }
        return sum;
    }


}
