package 代码随想录.链表;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead =new ListNode();
        ListNode cur= dummyhead;
        ListNode one=l1;
        ListNode two=l2;
        int exr=0;
        while (one!=null||two!=null){
            if(one==null){
                cur.next=new ListNode((two.val+exr)%10);
                exr=(two.val+exr)/10;
                cur=cur.next;
                two=two.next;
                continue;
            }
            if(two==null){
                cur.next=new ListNode((one.val+exr)%10);
                exr=(one.val+exr)/10;
                cur=cur.next;
                one=one.next;
                continue;
            }
            cur.next=new ListNode((one.val+two.val+exr)%10);
            exr=(one.val+two.val+exr)/10;
            cur=cur.next;
            one=one.next;
            two=two.next;
        }
        if(exr!=0){
            cur.next=new ListNode(exr);
        }
        return dummyhead.next;
    }

}
