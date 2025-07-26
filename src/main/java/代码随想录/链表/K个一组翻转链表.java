package 代码随想录.链表;

import 代码随想录.栈.前K个高频元素;

import java.util.ArrayList;
import java.util.List;

public class K个一组翻转链表 {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode cur = head;

        //循环里做k个一组的反转
        while (true) {
            ListNode end = cur;
            int count = 0;
            while (end != null && count < k) {
                end = end.next;
                count++;
            }
            if (count < k) break;
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

    //反转链表
    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode cur = head;
        //这里传入end就是判断一下，如果是end就结束
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        //头部节点
        ListNode cur=head;
        //尾部节点
        ListNode pre=dummyhead;
        int count=0;

        ListNode res=new ListNode();
        ListNode aa=res;

        while (pre!=null&&pre.next!=null){
            count++;
            pre=pre.next;
            if(count==k){
                //做一个链表反转
                count=0;

                ListNode next = pre.next;
                pre.next=null;
                //反转结束，返回尾/投部节点
                List<ListNode> listNodes = reverseList2(cur);
                //得到新头部，新尾部
                ListNode end = listNodes.get(0);
                ListNode start = listNodes.get(1);

                aa.next=end;
                start.next=next;

                aa=start;
                cur=start.next;
                pre=start;
            }
        }
        return res.next;
    }
    public List<ListNode> reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            //留着next
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return new ArrayList<ListNode>(List.of(pre,head));
    }
}