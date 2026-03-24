package 代码随想录.单调栈;

import java.util.*;

public class 柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(left,-1);
        Arrays.fill(right,heights.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <heights.length ; i++) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                right[stack.peek()]=i;
                stack.pop();
            }
            if(!stack.isEmpty())left[i]=stack.peek();
            stack.push(i);
        }
        int max=0;
        for (int i = 0; i <left.length; i++) max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);//只初始化右边界

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }

            if(!stack.isEmpty())left[i]=stack.peek();
            else left[i]=-1;
            stack.push(i);
        }

        int max=0;
        for (int i = 0; i <left.length; i++) max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        return max;
    }

    public int largestRectangleArea3(int[] heights) {
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;
        Deque<Integer> stack = new LinkedList<Integer>();
        int max =0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i]>=heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]) {
                    Integer mid = stack.peek();
                    stack.pop();
                    Integer left = stack.peek();
                    int height = heights[mid];
                    int bro=(i-left-1);
                    max=Math.max(bro*height,max);
                }
                stack.push(i);
            }
        }
        return max;
    }
}
