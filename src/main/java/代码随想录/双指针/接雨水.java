package 代码随想录.双指针;

import java.util.Stack;

public class 接雨水 {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            int peek = height[stack.peek()];
            if (!stack.isEmpty() && height[i] >= peek) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && height[i]<peek) {
                    Integer mid = stack.pop();
                    if(!stack.isEmpty()){
                        Integer left = stack.peek();
                        int h = Math.min(height[left], height[i])-height[mid];
                        int b = (i - left - 1);
                        res+=h*b;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }


}
