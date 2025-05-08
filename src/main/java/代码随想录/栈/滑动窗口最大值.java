package 代码随想录.栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }



    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        arrayList.add(myQueue.peek());
        for (int i =0; i <nums.length-k; i++) {
            myQueue.poll(nums[i]);
            myQueue.add(nums[i+k]);
            arrayList.add(myQueue.peek());
        }

        int[] ints = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ints[i]=arrayList.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        滑动窗口最大值 滑动窗口最大值 = new 滑动窗口最大值();
        滑动窗口最大值.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    //暴力解法，对但是通过不了，超时
    public int[] maxSlidingWindow2(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrayList.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if(res.size()!=0&&res.get(res.size()-1)<arrayList.get(arrayList.size()-1)){
                res.add(arrayList.get(arrayList.size()-1));
                arrayList.remove(0);
                arrayList.add(nums[i]);
                continue;
            }

            int max=Integer.MIN_VALUE+1;
            for (int j = 0; j<k; j++) {
                Integer index = arrayList.get(j);
                max= Math.max(index, max);
            }
            res.add(max);
            arrayList.remove(0);
            arrayList.add(nums[i]);
        }

        int max=Integer.MIN_VALUE+1;
        for (int i = 0; i < arrayList.size(); i++) {
            Integer index = arrayList.get(i);
            max= Math.max(index, max);
        }
        res.add(max);

        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i]=res.get(i);
        }
        return ints;
    }












}
