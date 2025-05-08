package 代码随想录.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class 最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (o1, o2)->Integer.compare(o1[0],o2[0]));
        //判断不重叠
        //判断重叠
        int sum=1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>points[i-1][1]){
                sum+=1;//必须加一个弓箭
            }else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
                // 更新重叠气球最小右边界
            }
        }
        return sum;
    }





}
