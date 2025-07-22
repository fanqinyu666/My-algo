package 代码随想录.链表;

public class 排序链表 {

    public ListNode sortList(ListNode head) {
        ListNode res = track(head);
        return res;
    }
    public ListNode track(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode fir=head;
        ListNode sec = slow.next;
        slow.next=null;
        //关键在于断开他
        ListNode first = track(fir);
        ListNode second = track(sec);
        return marge(first,second);
    }

    private ListNode marge(ListNode first, ListNode second) {
        ListNode dummy=new ListNode();
        ListNode pre=dummy;

        while (first!=null&&second!=null){
            int min = Math.min(first.val, second.val);
            if(min ==first.val){
                pre.next=first;
                first=first.next;
            }else {
                pre.next=second;
                second=second.next;
            }
            pre=pre.next;
        }
        pre.next = (first != null) ? first : second;
        return dummy.next;
    }

}
