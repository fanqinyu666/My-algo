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

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        //这里不能是head，必须是dummyNode，没有考虑到n=链表长度，是删除头节点
        ListNode cur =dummyNode;
        ListNode pre =dummyNode;

        for (;n>0;n--){
            cur=cur.next;
        }
        if(cur==null)return null;
        while (cur.next!=null){
            pre=pre.next;
            cur=cur.next;
        }
        pre.next=pre.next.next;
        return dummyNode.next;
    }

}
