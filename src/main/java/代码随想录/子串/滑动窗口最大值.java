package 代码随想录.子串;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {

    //背会这个写法，只能这样了其他都写不过，太恶心了

    //这个队列必须要写这俩方法
    class MyQueue {

        Deque<Integer> deque=new LinkedList<>();
        int capy;
        public MyQueue(int capy) {
            this.capy = capy;
        }
        //push和pop必须都写，和Last比较
        public void push(int x) {
            while(!deque.isEmpty()&&deque.getLast()<x)deque.removeLast();
            deque.addLast(x);
        }
        //如果是，就删除，不是就跳过
        public void pop(int i) {
            if(!deque.isEmpty()&&deque.getFirst()==i) deque.removeFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue(k);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++)myQueue.push(nums[i]);
        int idx = 0;
        res[idx++]=myQueue.deque.getFirst();

        //先出一个，在入一个
        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i-k]);
            myQueue.push(nums[i]);
            //然后getFirst一样
            res[idx++]=myQueue.deque.getFirst();
        }
        return res;
    }
}
