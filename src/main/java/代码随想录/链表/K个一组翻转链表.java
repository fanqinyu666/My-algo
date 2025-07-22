package 代码随想录.链表;

import 代码随想录.栈.前K个高频元素;

import java.util.List;

public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode pre=dummyhead;
        ListNode cur=head;

        while (true){
            ListNode end = cur;
            int count = 0;

            while(end != null && count < k) {
                end = end.next;
                count++;
            }
            if(count < k) break;

            ListNode newHead = reverse(cur, end);
            //传入的cur是1

            cur.next = end;
            pre.next = newHead;

            // 移动指针准备下一轮
            pre = cur;
            cur = end;
        }
        return dummyhead.next;
    }
    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode cur=head;
        while (cur!=end){
            ListNode next= cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


}
