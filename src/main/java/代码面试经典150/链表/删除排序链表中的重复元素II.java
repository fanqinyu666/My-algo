package 代码面试经典150.链表;

public class 删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;

        ListNode dummy = new ListNode();
        ListNode pre=dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null){
            //看到不一样的了
            if(fast.val!=slow.val) {
                //先判断之前是否重复过
                if(slow.next.val!=fast.val){
                    //直接丢弃
                    slow=fast;
                }else {
                    //记录当前这个
                    pre.next=slow;
                    slow=fast;
                    //一定要移动pre！
                    pre=pre.next;
                }
                fast=fast.next;
            }else {
                //如果是一样的
                fast=fast.next;
            }
        }
        if (slow.next == null) {
            pre.next = slow;
            pre = pre.next;
        }
        pre.next = null;
        return dummy.next;
    }

}
