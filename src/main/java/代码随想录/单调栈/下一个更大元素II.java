package 代码随想录.单调栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class 下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int[] res=new int[nums.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < res.length; i++) {
            res[i]=-1;
        }
        stack.push(0);
        int index=0;
        for (int i = 1; i < nums.length*2; i++) {
            index=i%nums.length;

            if(nums[stack.peek()]>=nums[index]){
                stack.push(index);//比较元素小于栈顶元素，直接加入栈内
            }else if(nums[stack.peek()]<nums[index]){

                while (!stack.isEmpty()&&nums[index]>nums[stack.peek()]){
                    res[stack.peek()]=nums[index];
                    stack.pop();
                }
                stack.push(index);

            }

        }
        return res;
    }

    public static void main(String[] args) {
        下一个更大元素II s = new 下一个更大元素II();
        s.nextGreaterElements2(new int[]{1,2,1});
    }
    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        stack.push(0);
        int index;


        for (int i = 1; i < nums.length*2; i++) {
            index=i%nums.length;
            if(nums[stack.peek()]>=nums[index]){
                stack.push(index);
            }else {
                while (!stack.isEmpty()&&nums[stack.peek()]<nums[index]){
                    res[stack.peek()]=nums[index];
                    stack.pop();
                }
                stack.push(index);
            }
        }
        return res;
    }
}
