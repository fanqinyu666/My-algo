package 代码随想录.滑动窗口;
import java.util.HashSet;


public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int slow=0,fast=0;
        int max=0;
        HashSet<Character> set = new HashSet<>();
        while (fast<s.length()){
            char c = s.charAt(fast);
            if (!set.contains(c)) {
                fast++;
                set.add(c);
            }else {
                while (set.contains(c)){
                    set.remove(s.charAt(slow));
                    slow++;
                }
            }
            max= Math.max(max,fast-slow);
        }
        return max;
    }



}
