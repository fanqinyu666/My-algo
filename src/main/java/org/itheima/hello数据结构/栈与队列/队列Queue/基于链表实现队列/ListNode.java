package org.itheima.hello数据结构.栈与队列.队列Queue.基于链表实现队列;

/* 链表节点类 */
class ListNode {
    int val;// 节点值
    ListNode next; // 指向下一节点的引用
    ListNode(int x) {val = x;}// 构造函数


    /* 在链表的节点 n0 之后插入节点 P */
    void insert(ListNode n0, ListNode P) {
        /*
        P.next=n0.next;
        n0.next=P;
        */

        ListNode n1 = n0.next;
        P.next = n1;
        n0.next = P;
    }


    /* 删除链表的节点 n0 之后的首个节点 */
    void remove(ListNode n0) {

        /*
        if (n0.next == null)
            return;
        n0.next=n0.next.next;
        */

        if (n0.next == null)
            return;

        // n0 -> P -> n1
        ListNode P = n0.next;
        ListNode n1 = P.next;
        n0.next = n1;
    }


    /* 访问链表中索引为 index 的节点 */
    ListNode access(ListNode head, int index) {
        /*
        for (int i = 0; i < index; i++) {
            if (head == null)//看什么时候头节点为空
                return null;
            head=head.next;//替换头节点
        }
        return head;
        */

        for (int i = 0; i < index; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        return head;
    }

    /* 在链表中查找值为 target 的首个节点 */
    int find(ListNode head, int target) {
        /*
        int index=0;
        while (head!=null) {
            if(head.val==target){
                return index;
            }
            head=head.next;
            index++;
        }
        return -1;
        */

        int index = 0;
        while (head != null) {
            //不确定链表的长度，不可用for，用while
            if (head.val == target)
                return index;
            head = head.next;
            index++;
        }
        return -1;
    }

}