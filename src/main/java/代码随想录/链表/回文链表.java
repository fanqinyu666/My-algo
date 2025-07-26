package 代码随想录.链表;

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow=slow.next;
        ListNode rHead = reverse(slow);
        while (rHead!=null){
            if (rHead.val!=head.val) {
                return false;
            }
            rHead=rHead.next;
            head=head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre=null;
        ListNode cur= head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}