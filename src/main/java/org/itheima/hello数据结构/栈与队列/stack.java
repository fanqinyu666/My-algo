package org.itheima.hello数据结构.栈与队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        //栈和队列的操作全是O(1)
        //出入，查询队首


        //动态数组构造的栈如果触发扩容机制O(n)

        //栈和列表一样是被封装好的
        /* 初始化栈 */
        Stack<Integer> stack = new Stack<>();
        /* 元素入栈 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        /* 访问栈顶元素 */
        int peek = stack.peek();
        /* 元素出栈 */
        int pop = stack.pop();
        /* 获取栈的长度 */
        int size = stack.size();
        /* 判断是否为空 */
        boolean isEmpty = stack.isEmpty();


        /* 初始化队列 */
        Queue<Integer> queue = new LinkedList<>();

        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        /* 访问队首元素 */
        int peek1 = queue.peek();

        /* 元素出队 */
        int pop1 = queue.poll();

        /* 获取队列的长度 */
        int size1 = queue.size();

        /* 判断队列是否为空 */
        boolean isEmpty1 = queue.isEmpty();

    }
}
