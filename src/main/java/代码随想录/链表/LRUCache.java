package 代码随想录.链表;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }




    private Deque<Integer> deque;
    HashMap map=new HashMap<Integer,Integer>();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

   /* public int get(int key) {
        if(map.containsKey(key)){



            Integer value =(Integer) map.get(key);
            return value;
        }

        return
    }*/

    public void put(int key, int value) {

        if (deque.size()+1>capacity) {
            Integer i = deque.removeFirst();
            map.remove(i);
        }

        deque.addLast(key);
        map.put(key,value);


    }
}
