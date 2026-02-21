package 代码面试经典150.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        //w,m,n
        int w = words[0].length(),m = words.length,n = s.length();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);


        // 使用滑动窗口,统计每个窗口内单词出现的次数, 滑动窗口的起点可以固定位一个单词的长度, 因为一个单词之后的窗口都是重复的
        for(int Start = 0; Start< w; Start ++) {
            int l = Start;
            int r = Start;
            Map<String, Integer> windowMap = new HashMap<>();
            // 这里要保证右边界能移动到最后一个字母, 所以要有等号

            while(r + w <= n) {
                //窗口右边界持续往后移动, 同时将经过的单词统计次数
                String word = s.substring(r, r + w);
                windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                r += w;

                while(windowMap.getOrDefault(word,0)>map.getOrDefault(word,0)) {
                    String leftWord = s.substring(l, l + w);
                    windowMap.put(leftWord, windowMap.getOrDefault(leftWord, 0) - 1);
                    l += w;
                }

                //窗口内 单词总数
                int num = (r-l) / w;
                if(num == m) {
                    result.add(l);
                }
            }
        }
        return result;
    }

}
