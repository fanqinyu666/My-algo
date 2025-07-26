package 代码随想录.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ArrayList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    ArrayList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                if (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    continue;
                }
                if (j < k && nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    continue;
                }
            }

        }
        return ArrayList;
    }

}
