package 算法复习_随手练.小练习;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class new_test {

    public class MaxValueUnderN {
        int res = -1;
        public int solve(int[] nums, int n) {
            Arrays.sort(nums);
            String target = String.valueOf(n);
            backtrack(nums, target, 0, true, 0);
            return res;
        }

        private void backtrack(int[] nums, String target, int index, boolean limit, int current) {
            if (index == target.length()) {
                if (current < Integer.parseInt(target)) res = Math.max(res, current);
                return;
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                if (limit && nums[i] > target.charAt(index) - '0') continue; // 超过当前位限制，跳过

                backtrack(nums, target, index + 1, limit && (nums[i] == target.charAt(index) - '0'), current * 10 + nums[i]);
                if (res != -1) return; // 贪心思想：一旦找到第一个符合条件的（从大到小找），就是最优解
            }

            // 如果第一位就没找到合适的，尝试减少位数（比如 n=100, 选最大两位数 99）
            if (index == 0) backtrack(nums, target, index + 1, false, 0);
        }
    }


}