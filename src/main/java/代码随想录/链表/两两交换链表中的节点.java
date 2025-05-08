package 代码随想录.链表;

public class 两两交换链表中的节点 {



    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode();
        dumyhead.next=head;
        ListNode cur=dumyhead;//我们需要让cur指向dumyhead，这样才能上去操作第一个节点和第二个节点（）

        while (cur.next==null&&cur.next.next==null){
            ListNode next = cur.next;//1
            ListNode nn = cur.next.next;//2
            next.next=nn.next;//1-3
            nn.next=next;//2-1-3
            cur=next;//cur=1

        }

        return head;
    }
}
