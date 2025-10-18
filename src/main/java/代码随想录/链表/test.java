package 代码随想录.链表;

public class test {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1=headA;
        ListNode head2=headB;
        while (head1!=head2){
            if(head1!=null){
                head1=head1.next;
            }else {
                head1=headB;
            }
            if(head2!=null){
                head2=head2.next;
            }else{
                head2=headA;
            }
        }
        return head1;
    }
}
