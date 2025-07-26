package 代码随想录.链表;

import java.util.HashMap;

public class Shopee一面 {
    public static void main(String[] args){

        ListNode a=new ListNode(1);
        ListNode b=new ListNode(1);
        ListNode c=new ListNode(1);
        ListNode d=new ListNode(2);
        ListNode e=new ListNode(3);
        ListNode f=new ListNode(3);
        ListNode g=new ListNode(4);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;

        test(a);

    }
    public static ListNode test(ListNode head){
        if(head == null) return null;
        //虚拟头节点
        ListNode dummy=new ListNode();
        ListNode pre=dummy;

        pre.next = head;
        ListNode cur = head;

        while(cur!=null&&cur.next!=null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
