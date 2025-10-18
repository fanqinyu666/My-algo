package 代码随想录.子串;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class tes {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ints=new int[nums.length-k+1];
        MyQueue myQueue=new MyQueue();
        for(int i=0;i<k-1;i++){
            myQueue.put(nums[i]);
        }
        for(int i=k-1;i<nums.length;i++){
            myQueue.put(nums[i]);
            ints[i-(k-1)]=myQueue.deque.getFirst();
            myQueue.remove(nums[i-(k-1)]);
        }
        return ints;
    }
    class MyQueue{
        Deque<Integer> deque=new LinkedList<>();
        public void put(int num){
            while(!deque.isEmpty()&&deque.getLast()<num){
                deque.removeLast();
            }
            deque.addLast(num);
        }
        public void remove(int size){
            if(size==deque.getFirst()){
                deque.removeFirst();
            }
        }
    }
}
