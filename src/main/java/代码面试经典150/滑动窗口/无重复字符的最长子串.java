package 代码面试经典150.滑动窗口;

import java.util.HashMap;
import java.util.HashSet;

public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty() ||s.length()==1)return s.length();
        HashSet<Character> set = new HashSet<>();
        int max=0;
        int left=0,right=1;
        set.add(s.charAt(0));
        while (right<s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            max=Math.max(max,set.size());
        }
        return max;
    }

}
