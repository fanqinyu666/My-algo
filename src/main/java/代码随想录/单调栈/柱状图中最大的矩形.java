package 代码随想录.单调栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class 柱状图中最大的矩形 {


    int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }

    public int largestRectangleArea2(int[] heights) {
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
