package 代码随想录.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();//二位集合
        Arrays.sort(nums);//排序数组

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  //去重a
                //i=0的时候不需要去重
                //i>0的时候，判断当前的元素和前一个元素是否一样
                //为何不是nums[i] == nums[i + 1]，并让i从0开始遍历呢？
                continue;
            }
            int left = i + 1;//他俩位置要理解
            int right = nums.length - 1;
            while (right > left) {//不可相等，相等就不是三元了，而是二元
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {//等于0的时候就存入一个数组，存入集合
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();//二位集合
        Arrays.sort(nums);//排序数组

        for (int i = 0; i <nums.length; i++) {
            if(nums[i]>0){
                return result;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum= nums[i] + nums[left] + nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[right]!=nums[right-1])right--;
                    while (nums[left]!=nums[right+1])left++;

                }
            }
        }
        return result;
    }


}
