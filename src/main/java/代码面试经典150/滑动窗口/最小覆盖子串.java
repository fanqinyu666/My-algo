package 代码面试经典150.滑动窗口;

import java.util.HashMap;
import java.util.Objects;

public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        if(s.isEmpty()||t.isEmpty())return "";
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();
        for (int i=0;i<t.length();i++)mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0)+1);

        //需要满足条件数和已经满足条件数
        int tcount=mapt.size(),hive=0;
        //结果字符串起点和最小长度
        int start=0,reslen=Integer.MAX_VALUE;
        //滑动窗口左右
        int left=0,right=0;

        while (right<s.length()){
            if (mapt.containsKey(s.charAt(right))) {
                maps.put(s.charAt(right),maps.getOrDefault(s.charAt(right),0)+1);
                if(Objects.equals(maps.get(s.charAt(right)), mapt.get(s.charAt(right)))){
                    //如果相等，hive++
                    hive++;
                }
            }
            //收缩左边界
            while (hive==tcount){
                if(right-left+1<reslen){
                    reslen=right-left+1;
                    start=left;
                }
                //更新left对应元素的频率
                if(mapt.containsKey(s.charAt(left)))if(Objects.equals(mapt.get(s.charAt(left)), maps.get(s.charAt(left))))hive--;
                maps.put(s.charAt(left),maps.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
            //扩大右边界
            right++;
        }
        if(reslen==Integer.MAX_VALUE)return "";
        return s.substring(start,start+reslen);
    }

}
