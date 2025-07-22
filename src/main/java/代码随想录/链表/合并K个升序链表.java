package 代码随想录.链表;

public class 合并K个升序链表 {


    //按照我的代码风格写出来的代码

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode track = track(lists);
        return track;
    }
    public ListNode track(ListNode[] lists){
        if(lists.length==1)return lists[0];
        ListNode[] res = new ListNode[(lists.length + 1) / 2];
        for (int i=0;i<lists.length;i+=2) {
            ListNode[] listNodes = new ListNode[2];
            listNodes[0]=lists[i];
            if(i+1<lists.length){
                listNodes[1]=lists[i+1];
            }else {
                listNodes[1]=null;
            }
            ListNode marge = marge(listNodes);
            res[i/2]=marge;
        }
        return track(res);
    }

    private ListNode marge(ListNode[] lists) {
        ListNode dummy=new ListNode();
        ListNode pre=dummy;
        ListNode first=lists[0];
        ListNode second=lists[1];

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
