package 算法复习.小练习;

import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node() {
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> map=new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            //得到节点
            Node node = map.get(key);
            tiqian(key);
            return node.value;
        }else {
            return -1;
        }

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            tiqian(key);

        }else {
            Node node = new Node(key, value);
            if(map.size()==capacity) {
                Node remove = tail.prev;
                map.remove(remove.key);
                Node prev2 = remove.prev;
                prev2.next = tail;
                tail.prev = prev2;
            }
            map.put(key, node);
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }
    }

    public void tiqian(int key) {

        Node node = map.get(key);

        Node npre = node.prev;
        Node nnex = node.next;

        npre.next=nnex;
        nnex.prev=npre;

        Node nex = head.next;

        node.prev = head;
        node.next = nex;

        nex.prev=node;
        head.next = node;
    }
}