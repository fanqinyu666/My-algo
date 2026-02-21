package 算法复习_随手练.二次尝试;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    Deque<Integer> deque=new LinkedList();
    int size=0;

    public MyQueue(int size) {
        this.size = size;
    }
    public void add(int num){
        if(deque.size()==size){
            deque.removeFirst();
            while (!deque.isEmpty()&&deque.getFirst()<deque.getLast()){
                deque.removeFirst();
            }
        }

        while (!deque.isEmpty()&&deque.getFirst()<num){
            deque.removeFirst();
        }
        deque.add(num);

    }



}
