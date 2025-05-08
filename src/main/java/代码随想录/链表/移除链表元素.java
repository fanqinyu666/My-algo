package 代码随想录.链表;

public class 移除链表元素 {

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;

    }


    public ListNode removeElements2(ListNode head, int val) {
        if(head==null){
            return null ;
        }
        ListNode dummyhead = new ListNode();
        dummyhead.next=head;

        ListNode temp=dummyhead;

        while (temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
            }else {

                temp = temp.next;
            }
        }
        return head;

    }



}
