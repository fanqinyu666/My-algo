package 代码随想录.链表;

public class test {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode brack = brack(lists);
        return brack;
    }

    private ListNode brack(ListNode[] lists) {

    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode f1=list1,f2=list2;
        ListNode dummyhead=new ListNode();
        ListNode cur=dummyhead;
        while (f1!=null&&f2!=null){
            if(f1.val> f2.val){
                //下面4句是核心，就是添加一个节点前，把他从原本链表拆分
                ListNode next = f2.next;
                f2.next=null;
                cur.next=f2;
                f2=next;
            }else {
                ListNode next = f1.next;
                f1.next=null;
                cur.next=f1;
                f1=next;
            }
            cur=cur.next;
        }

        if(f1!=null){
            cur.next=f1;
        }else {
            cur.next=f2;
        }
        return dummyhead.next;
    }

}