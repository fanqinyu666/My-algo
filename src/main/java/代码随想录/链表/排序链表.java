package 代码随想录.链表;

public class 排序链表 {
    //入口
    public ListNode sortList(ListNode head) {
        ListNode res = track(head);
        return res;
    }

    public ListNode track(ListNode head){
        //终止条件
        if(head==null||head.next==null)return head;

        ListNode slow=head;
        ListNode fast=head.next;
        //找到一半
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode fir=head;
        ListNode sec = slow.next;
        //断开左右
        slow.next=null;

        //递归断开
        ListNode first = track(fir);
        ListNode second = track(sec);
        //最后合并
        return mergeTwoLists(first,second);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    //归并排序，很简单的
    private ListNode marge(ListNode first, ListNode second) {
        ListNode dummy=new ListNode();
        ListNode pre=dummy;

        while (first!=null&&second!=null){
            int min = Math.min(first.val, second.val);
            if(min ==first.val){
                pre.next=first;
                first=first.next;
            }else {
                pre.next=second;
                second=second.next;
            }
            pre=pre.next;
        }
        pre.next = (first != null) ? first : second;
        return dummy.next;
    }

}
