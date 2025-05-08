package 代码随想录.链表;

public class MyLinkedList {
    ListNode head;
    int val;

    public MyLinkedList(ListNode head, int val) {
        this.head = head;
        this.val = val;
    }

    public int get(int index) {
        ListNode res = this.head;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res.val;
    }

    public void addAtHead(int val) {
        ListNode res = new ListNode(val);
        res.next = this.head;
        head = res;
    }

    public void addAtTail(int val) {
        ListNode now = head;
        ListNode res = new ListNode(val);
        while (now.next != null) {
            now = now.next;
        }
        now.next = res;
    }

    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        ListNode now = this.head;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        newNode.next = now.next.next;
        now.next = newNode;
    }

    public void deleteAtIndex(int index) {
        ListNode m = new ListNode();//虚拟头节点
        m.next = head;
        int count = 0;
        while (m.next != null) {
            if (count == index) {
                m.next = m.next.next;
                return;
            }
            m = m.next;
            count++;
        }
    }
    //反转链表
    /*public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }*/
    public ListNode reverseList(ListNode head) {
        ListNode dumyHead=null;
        ListNode pre=dumyHead;
        ListNode cur = head;
        while (cur.next!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return cur;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode pre =null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //pre,cur,next
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode();
        dumyhead.next=head;
        ListNode cur=dumyhead;//我们需要让cur指向dumyhead，这样才能上去操作第一个节点和第二个节点（）
        while (cur.next!=null&&cur.next.next!=null){
            ListNode next1= cur.next;//0-1-2-3(1)
            cur.next=cur.next.next;//0-2
            ListNode next2 = cur.next.next;
            cur.next.next=next1;//0-2-1-  3丢失了
            cur.next.next.next=next2;
            cur=cur.next.next;
        }
        return dumyhead.next;

    }
    //移除倒数第n个元素
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //新建一个虚拟头节点指向head
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        //快慢指针指向虚拟头节点
        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;
        for (int i = 0; i <= n; i++) {//n+1轮
            fastIndex = fastIndex.next;
        }//快指针指向的是第n个节点
        while (fastIndex != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        if (slowIndex.next != null) {
            slowIndex.next = slowIndex.next.next;
        }
        return dummyNode.next;
    }
    //环形链表
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {//两步两步跳，所以判断两个
            slow = slow.next;
            fast = fast.next.next;//不会出现空指针异常，while不会
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;

                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;//这俩返回哪个都可以
            }
        }
        return null;

    }

}










