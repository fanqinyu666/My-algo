package 其他算法.其他.排序算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 桶排序 {
    void bucketSort(float[] nums) {
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }
        for (float num : nums) {
            int i = (int) (num * k);
            buckets.get(i).add(num);
        }
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }
        int i = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                nums[i++] = num;
            }
        }
    }


}
