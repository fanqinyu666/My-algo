package 代码面试经典150.链表;

import java.util.HashMap;

public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }


    HashMap<Integer, Node> map=new HashMap<Integer, Node>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity){
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    public void put(int key,int value){
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value=value;
            get(key);
        }else {
            if (map.size() == capacity) {
                //去尾
                Node prev = tail.prev;
                Node prev1 = prev.prev;
                prev1.next = tail;
                tail.prev = prev1;
                map.remove(prev.key);
            }
            //直接添加
            Node node = new Node(key, value);

            Node next = head.next;

            node.next = next;
            node.prev = head;

            head.next = node;
            next.prev = node;
            //添加
            map.put(key, node);
        }
    }
    public int get(int key){
        if (!map.containsKey(key))return -1;
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        //去除
        prev.next=next;
        next.prev=prev;

        Node next1 = head.next;

        node.next=next1;
        node.prev=head;

        head.next=node;
        next1.prev=node;
        return node.value;
    }



}
