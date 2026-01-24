package 其他算法.其他.其他;

import java.util.List;

public class test {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;

        ListNode pre=dummy;
        ListNode cur=dummy;
        while (cur.next!=null&&n!=0){
            n--;
            cur=cur.next;
        }
        while (cur.next!=null){
            cur=cur.next;
            pre=pre.next;
        }
        if (pre.next!=null) {
            pre.next=pre.next.next;
        }
        return dummy.next;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null&&cur.next!=null){
            ListNode next = cur.next;
            ListNode next1 = cur.next.next;
            pre.next=next;//0-1-2
            next.next=cur;//2-3-1
            cur.next=next1;//1-2-3

            pre=cur;
            cur=next1;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode();
        ListNode cur = head;
        dummy.next = cur;
        ListNode pre = dummy;
        while (cur != null) {
            int index = 1;
            while (cur != null && index != k) {
                cur = cur.next;
                index++;
            }
            if (cur == null) break;
            //前面接入
            ListNode next = pre.next;
            pre.next = null;
            //后面接入
            ListNode next1 = cur.next;
            cur.next = null;
            //反转，给最前面的，返回的是最后的
            ListNode reverse = reverse(next);
            pre.next = reverse;

            next.next = next1;
            pre = next;
            cur = next1;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }











}
