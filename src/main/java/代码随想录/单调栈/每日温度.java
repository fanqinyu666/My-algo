package 代码随想录.单调栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] res=new int[temperatures.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=0;
        }
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if(temperatures[stack.peek()]>=temperatures[i]){
                stack.push(i);//比较元素小于栈顶元素，直接加入栈内
            }else if(temperatures[stack.peek()]<temperatures[i]){
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;
            int[] ans = new int[length];
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < length; i++) {
                int temperature = temperatures[i];
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    int prevIndex = stack.pop();
                    ans[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }
            return ans;
        }
    }

}
