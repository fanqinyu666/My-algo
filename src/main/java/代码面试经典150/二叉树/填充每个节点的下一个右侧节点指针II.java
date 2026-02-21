package 代码面试经典150.二叉树;

import org.w3c.dom.Node;
import 代码面试经典150.链表.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class 填充每个节点的下一个右侧节点指针II {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        //不判断这个就是一直报错
        if (root == null) return null;
        Deque<Node> deque = new LinkedList<>();
        //加入一个先
        deque.add(root);
        Node res=root;
        //只要你不为null
        while (!deque.isEmpty()){
            int size = deque.size();
            LinkedList<Node> deque2 = new LinkedList<>();
            while (!deque.isEmpty()&&size>0){
                //最左边开始
                Node node = deque.removeFirst();
                //有其他值，null指向最近的
                if(!deque.isEmpty())node.next=deque.peekFirst();
                if(node.left!=null)deque2.addLast(node.left);
                if(node.right!=null)deque2.addLast(node.right);
                size--;
            }
            deque=deque2;
        }
        return res;
    }

}