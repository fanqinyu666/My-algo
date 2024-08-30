package org.itheima.hello数据结构.栈与队列.栈Stack.基于链表实现栈;

/* 基于链表实现的栈 */
class LinkedListStack {

    private ListNode stackPeek; // 将头节点作为栈顶
    private int stkSize = 0; // 栈的长度

    public LinkedListStack() {
        stackPeek = null;
    }

    /* 获取栈的长度 */
    public int size() {
        return stkSize;
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入栈 */
    public void push(int num) {
        ListNode node=new ListNode(num);

        node.next = stackPeek;//将未来头节点node.next指向目前头stackPeek
        stackPeek = node;//再替换头节点
        stkSize++;//长度加
    }

    /* 出栈 */
    public int pop() {

        int num = peek();//先得到数据
        stackPeek = stackPeek.next;//出栈
        stkSize--;
        return num;//返回数据
    }

    /* 访问栈顶元素 */
    public int peek() {

        if (isEmpty())
            throw new IndexOutOfBoundsException();
        //返回栈顶元素，也就是头节点元素
        return stackPeek.val;
    }

    /* 将 List链表 转化为 Array数组 并返回 */
    public int[] toArray() {
        int[] res=new int[size()];
        ListNode node=stackPeek;
        for (int i = 0; i < size(); i++) {
            res[i]=node.val;
            node=node.next;
        }
        return res;
    }
}