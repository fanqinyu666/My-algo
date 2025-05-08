package 代码随想录.单调栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class 接雨水 {
    //单调栈
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int sum =0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if(height[stack.peek()]>=height[i]){
                stack.push(i);//等于的时候，可以直接入栈，也可以先剔除再加入
            }else if(height[stack.peek()]<height[i]){
                while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        //这里还要再判断栈是否为空，因为你pop了一个
                        int left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0) sum += hold;
                    }
                }
                stack.push(i);
            }
        }
        return sum ;
    }


    public int trap2(int[] height) {
        int sum=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <height.length ; i++) {
            if(height[stack.peek()]>=height[i]){
                stack.push(i);
            }else {
                while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                    Integer mid = stack.pop();
                    if(!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int min = Math.min(height[left], height[i]);
                        sum += (min - height[mid]) * (i - stack.peek()-1);
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}




















