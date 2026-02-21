package 代码面试经典150.链表;

public class 旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;

        int len = 1;
        ListNode oldTail = head;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            len++;
        }
        k = k % len;

        if (k == 0) return head;
        ListNode dummy = new ListNode();
        ListNode pre=dummy;
        ListNode cur = head;
        while (cur.next!=null&&k>0) {
            cur=cur.next;
            k--;
        }
        ListNode next = cur.next;
        ListNode c=null;
        cur.next=null;
        while (c.next!=null){
            c=next.next;
        }
        c.next=head;
        return next;
    }

    //连成环不需要害怕null
    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;

        if (add == n) {
            return head;
        }

        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

}
