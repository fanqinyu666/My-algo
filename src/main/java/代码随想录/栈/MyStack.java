package 代码随想录.栈;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;


    public MyStack(){
        queue=new LinkedList<>();
    }
    void push(int x){
        queue.add(x);
    }

    int pop(){
        for (int i = 0; i < queue.size()-1; i++) {
            Integer remove = queue.remove();
            queue.add(remove);
        }
        return queue.remove();
    }

    int top(){

        for (int i = 0; i < queue.size()-1; i++) {
            Integer remove = queue.remove();
            queue.add(remove);
        }
        Integer remove = queue.remove();
        queue.add(remove);
        return remove;
    }
    boolean empty(){
        return queue.isEmpty();
    }




}
