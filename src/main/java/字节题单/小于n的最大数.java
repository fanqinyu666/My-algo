package 字节题单;

import java.util.Arrays;

public class 小于n的最大数 {

    int res = -1;
    public int solve(int[] nums, int n) {
        Arrays.sort(nums);
        String target = String.valueOf(n);
        // 从第0位开始，limit=true表示受n的数字限制
        backtrack(nums, target, 0, true, 0);
        return res;
    }

    private void backtrack(int[] nums, String target, int index, boolean limit, int current) {
        if (index == target.length()) {
            if (current < Integer.parseInt(target))res = current;
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果受限，且当前数字大于n的对应位，跳过（不能比n大）,如果不受限，上一个值不是=，其实下一个是完全可以大于的
            if (limit && nums[i] > target.charAt(index) - '0') continue;

            // 新的 limit 取决于：原来就受限 且 现在的数字也等于上限数字
            backtrack(nums, target, index + 1, limit && (nums[i] == target.charAt(index) - '0'), current * 10 + nums[i]);

            // 关键：因为是从大到小试的，一旦 res 有值了，说明找到了最优解，直接一路 return，这就是贪心！
            if (res != -1) return;
        }

        // 特殊处理：如果在第一位(index=0)没能找到合适的（或者尝试了一圈没结果）
        // 比如 n=10, nums={2, 3}，第一位就没法填。
        // 那么我们就尝试拼一个比 n 少一位的数（比如全填 nums 里的最大值）
        if (index == 0 && res == -1) {
            // 这种情况下，limit 变为 false，不再受 n 的每一位限制
            backtrack(nums, target, index + 1, false, 0);
        }
    }

}
