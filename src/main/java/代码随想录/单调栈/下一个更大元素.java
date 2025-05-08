package 代码随想录.单调栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class 下一个更大元素 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] res=new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=-1;
        }
        //构建数组1的hashmap，k是值，v是下标。数组2可以用contain判断是否有这个数组一的值
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }


        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if(nums2[stack.peek()]>=nums2[i]){
                stack.push(i);//比较元素小于栈顶元素，直接加入栈内
            }else if(nums2[stack.peek()]<nums2[i]){
                while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                    if (hashMap.containsKey(nums2[stack.peek()])){
                        res[hashMap.get(nums2[stack.peek()])]=nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }


}
