package 代码随想录.链表;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){

            ListNode next = cur.next;
            //留着next
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
