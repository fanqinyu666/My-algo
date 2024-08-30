package org.itheima.hello算法.搜索;

import java.util.HashMap;
import java.util.Map;
//给定一个整数数组 nums 和一个目标元素 target ，请在数组
// 中搜索“和”为 target 的两个元素，并返回它们的数组索引。返回任意一个解即可。
public class 哈希优化策略 {
    //线性查找：以时间换空间
    /* 方法一：暴力枚举 */
    int[] twoSumBruteForce(int[] nums, int target) {
        int size = nums.length;
        // 两层循环，时间复杂度为 O(n^2)
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return new int[0];
    }

    //哈希查找：以空间换时间
    /* 方法二：辅助哈希表 */
    int[] twoSumHashTable(int[] nums, int target) {
        int size = nums.length;
        // 辅助哈希表，空间复杂度为 O(n)
        Map<Integer, Integer> dic = new HashMap<>();
        // 单层循环，时间复杂度为 O(n)
        for (int i = 0; i < size; i++) {
            if (dic.containsKey(target - nums[i])) {
                return new int[] { dic.get(target - nums[i]), i };
            }
            dic.put(nums[i], i);
        }
        return new int[0];
    }


}
