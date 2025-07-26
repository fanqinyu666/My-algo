package 代码随想录.链表;

public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a=headA;
        ListNode b=headB;
        while (a!=b){
            if(a!=null){
                a=a.next;
            }else {
                a=headB;
            }
            if(b!=null){
                b=b.next;
            }else {
                b=headA;
            }
        }
        return a;
    }
}
