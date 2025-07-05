package 算法复习.小练习;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }

    public class MyQueue{
        Deque<Integer> deque = new LinkedList<>();
        int size = 0;
        public MyQueue(int size){
            this.size=size;
        }
        public void add(int i){
            while (!deque.isEmpty() && i > deque.getFirst()) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        public void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue(k);
        int[] res = new int[nums.length - k+1];
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        int index=0;
        res[index++]=myQueue.deque.getFirst();
        for (int i = k; i <nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[index++] = myQueue.deque.getFirst();
        }
        return res;
    }

}

