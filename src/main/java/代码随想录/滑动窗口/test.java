package 代码随想录.滑动窗口;

import java.util.HashSet;

public class test {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left=0,right=0;
        while (right<s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            max=Math.max(max,right-left+1);
        }
        return max;
    }
    public int trap(int[] height) {
        int max=0;
        int leftMax=0,rightMax=0;
        int left=0,right=height.length-1;
        while (left<right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(leftMax<rightMax){
                max+=leftMax-height[left];
                left++;
            }else{
                max+=rightMax-height[right];
                right--;
            }
        }
        return max;
    }
}
