package 代码面试经典150.区间;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> integers = new ArrayList<>();
        int left=0,right=0;
        while (right<nums.length){
            while (right<nums.length-1&&nums[right+1]==nums[right]+1){
                right++;
            }
            //加入
            if(right!=left){
                StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(nums[left]);
                    stringBuilder.append("->");
                    stringBuilder.append(nums[right]);
                    integers.add(stringBuilder.toString());
            }else integers.add(String.valueOf(nums[right]));
            //改边界
            left=right+1;
            right++;
        }
        return integers;
    }

}
