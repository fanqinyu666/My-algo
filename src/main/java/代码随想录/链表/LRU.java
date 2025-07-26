package 代码随想录.链表;

import java.util.HashMap;

class LRU {
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

    public LRU(int capacity){
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    public void put(int key,int value){
        //如果存在，就更新最前面
        if(map.containsKey(key)){
            Node node=map.get(key);
            //修改节点的前后
            Node next=node.next;
            Node prev=node.prev;

            next.prev=prev;
            prev.next=next;

            //修改头节点
            Node hNext=head.next;
            head.next=node;
            //修改node节点
            node.prev=head;
            node.next=hNext;

            //修改头节点的后一个节点
            hNext.prev=node;

            node.value=value;
        }else{
            //不存在，就添加节点，判断是否超最大长度

            Node node=new Node(key,value);
            //修改头节点
            Node hNext=head.next;
            head.next=node;
            //修改node节点
            node.prev=head;
            node.next=hNext;

            hNext.prev=node;
            map.put(key,node);
            if(map.size()>capacity){
                //删除末尾节点
                Node pTail=tail.prev;
                Node ll=pTail.prev;

                ll.next=tail;
                tail.prev=ll;

                map.remove(pTail.key);
            }
        }

    }
    public int get(int key){
        if(map.containsKey(key)){
            Node node=map.get(key);

            Node next=node.next;
            Node prev=node.prev;

            next.prev=prev;
            prev.next=next;

            //修改头节点
            Node hNext=head.next;
            head.next=node;
            //修改node节点
            node.prev=head;
            node.next=hNext;

            //修改头节点的后一个节点
            hNext.prev=node;
            return node.value;
        }else{
            return -1;
        }
        //存在就返回value
        //不存在就返回-1
    }


}