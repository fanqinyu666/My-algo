package 代码随想录.链表;

public class 删除链表的倒数第N个节点 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        //新建一个虚拟头节点指向head
        ListNode dummyNode = new ListNode(0);

        dummyNode.next = head;

        ListNode cur =dummyNode;
        ListNode pre =head;
        for (;n-1>0;n--){
            pre=pre.next;
        }
        while (pre.next!=null){
            pre=pre.next;
            cur=cur.next;
        }
        cur.next=cur.next.next;

        return dummyNode.next;
    }









}
