package 代码随想录.链表;
import java.util.HashMap;

public class 随机链表的复制 {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map= new HashMap<>();
        Node cur=head;
        while (cur!=null){
            //核心，创建一个新节点
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        cur=head;
        while (cur!=null){
            Node newNode = map.get(cur);
            newNode.next= map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}
