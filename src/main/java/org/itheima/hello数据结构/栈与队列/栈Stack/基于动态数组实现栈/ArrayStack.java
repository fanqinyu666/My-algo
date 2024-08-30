package org.itheima.hello数据结构.栈与队列.栈Stack.基于动态数组实现栈;

import java.util.ArrayList;

/* 基于数组实现的栈 */
//较为简单，基本使用自制列表的方法实现
class ArrayStack {
    //列表就是动态数组,用动态数组(列表)实现栈
    private ArrayList<Integer> stack;

    public ArrayStack() {
        // 初始化列表（动态数组）
        stack = new ArrayList<>();
    }

    /* 获取栈的长度 */
    public int size() {
        return stack.size();
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入栈 */
    public void push(int num) {
        stack.add(num);
    }

    /* 出栈 */
    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.remove(size() - 1);
    }

    /* 访问栈顶元素 */
    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.get(size() - 1);
    }

    /* 将 List(列表) 转化为 Array(数组) 并返回 */
    public Object[] toArray() {
        return stack.toArray();
    }
}