package 算法复习.复习2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {this.key=key; this.value=value;}
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size=0;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if(dLinkedNode==null)return -1;

        DLinkedNode next = dLinkedNode.next;
        DLinkedNode prev = dLinkedNode.prev;
        next.prev=prev;
        prev.next=next;
        DLinkedNode headold= head.next;
        headold.prev=dLinkedNode;
        dLinkedNode.next=headold;
        dLinkedNode.prev=head;
        head.next=dLinkedNode;
        return dLinkedNode.value;
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            // 移动节点到头部
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            return;
        }
        // 其余代码保持不变...
    }
}
