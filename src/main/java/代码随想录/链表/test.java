package 代码随想录.链表;

import java.util.HashMap;

public class test {
    class Node{
        Node next;
        Node prev;
        int key;
        int value;
    }
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer,Node> map;

    public test(Node head, Node tail, int capacity, HashMap<Integer, Node> map) {
        this.head = head;
        this.tail = tail;
        this.capacity = capacity;
        this.map = map;
    }


    public void put(int key, int value){
        //没有就添加头部
        if(!map.containsKey(key)){
            //判断大小是否限制
            if(map.size()==capacity){
                //加入头部，删除尾部




            }else {
             //直接加入头部

            }
        }else {
            //有就put改变值，并提到前面
            Node node = map.get(key);
            node.value=value;
            Node prev = node.prev;
            Node next = node.next;
            //头部下一个
            Node next1 = head.next;

            head.next=node;
            node.prev=head;

            node.next=next1;
            next1.prev=node;

            prev.next=next;
            next.prev=prev;
        }


    }


}