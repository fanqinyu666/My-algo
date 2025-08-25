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
    //双指针解法
    public int trap2(int[] height) {
        int left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        int max=0;
        while (left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(leftMax<rightMax){
                max+=leftMax-height[left];
                left++;
            }else {
                max+=rightMax-height[right];
                right--;
            }
        }
        return max;
    }
}
