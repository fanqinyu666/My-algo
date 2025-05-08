package 代码随想录.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {

        nums = IntStream.of(nums)
                //返回一个IntStream流对象，里面的值都是int数组，也就是int类型
                .boxed()
                //装箱，.boxed(): 将IntStream中的原始int值转换成Integer对象。
                // 这是因为int是原始数据类型，不能直接用于比较操作（如排序），需要转换为对象类型Integer。
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                //降序，大的在前
                .mapToInt(Integer::intValue)
                //将Interger类转换成int类，调用Integer::intValue
                .toArray();

        int len = nums.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k> 0) {
                nums[i] = -nums[i];
                k--;
            }
            if(k==0){
                break;
            }
        }
        if (k%2 == 1) nums[len - 1] = -nums[len - 1];

        for (int i = 0; i < len; i++) {
            sum+=nums[i];
        }
        return sum;
    }
}
