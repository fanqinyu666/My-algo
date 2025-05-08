package 代码随想录.链表;

public class 环形链表 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //判断快指针是不是为空，因为快指针走在前面，不需要判断慢指针，他走后面
            slow = slow.next;
            fast = fast.next.next;//不会出现空指针异常，while不会
            if (slow == fast) {// 如果快慢指针相遇了，说明有环

                ListNode index1 = fast;
                ListNode index2 = head;

        // 两个指针fast，head，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环的入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;//这就是环形链表入口，为何，数学式子而已
            }
        }
        return null;

    }
}
