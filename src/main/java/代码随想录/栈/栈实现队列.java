package 代码随想录.栈;

import java.util.Stack;

class MyQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>(); // 负责进栈
        stack2 = new Stack<>(); // 负责出栈
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        dumpstackIn();
        return stack2.pop();
    }

    public int peek() {
        dumpstackIn();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() &&stack2.isEmpty();
    }

    private void dumpstackIn() {
        if(!stack2.isEmpty()) {
        return;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}

