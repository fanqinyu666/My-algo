package org.itheima.hello数据结构.栈与队列.队列Queue.双向队列.基于双向链表;

class ListNode {
    int val; // 节点值
    ListNode next; // 后继节点引用
    ListNode prev; // 前驱节点引用

    ListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}
