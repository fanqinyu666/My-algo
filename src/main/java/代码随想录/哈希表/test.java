package 代码随想录.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int i1 = nums[i] + nums[j] + nums[k];
                if (i1 == 0) {
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    lists.add(List.of(nums[i], nums[j], nums[k]));
                } else if (i1 < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return lists;
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max=0;
        stack.add(0);
        for (int i=1;i<height.length;i++){
            int ls = height[i];
            if(ls<=height[stack.peek()]) {
                stack.add(i);
            }else{
                while (!stack.isEmpty()&&ls>height[stack.peek()]){
                    Integer pop= stack.pop();
                    if(!stack.isEmpty()){
                        Integer peek = stack.peek();
                        int h = Math.min(height[peek], ls) - height[pop];
                        max+=h*(i-peek-1);
                    }
                }
                stack.add(i);
            }
        }
        return max;
    }












}