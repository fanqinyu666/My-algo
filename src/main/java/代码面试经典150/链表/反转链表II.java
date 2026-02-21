package 代码面试经典150.链表;

import 代码面试经典150.区间.插入区间;

public class 反转链表II {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode cur=dummy;

        int step = right - left;
        while (cur!=null&&left>1){
            cur=cur.next;
            left--;
        }
        ListNode startd=cur;

        for (int i = 0; i <= step; i++) {
            cur = cur.next;
        }
        ListNode endd = cur;
        ListNode next = endd.next;
        //切断
        endd.next=null;
        ListNode start = startd.next;
        startd.next=null;

        ListNode listNode = reverseLinkedList(start);
        start.next=next;
        startd.next=listNode;

        return dummy.next;
    }
    private ListNode reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
