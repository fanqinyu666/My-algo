package 代码随想录.子串;

import java.util.HashMap;

public class 最小覆盖子串 {


    public String minWindow(String s, String t) {
        //结果
        int res=Integer.MAX_VALUE,start=0;
        //满足的条件数量
        HashMap<Character, Integer> smp = new HashMap<>();
        HashMap<Character, Integer> tmp = new HashMap<>();
        for (int i=0;i<t.length();i++)tmp.put(t.charAt(i),tmp.getOrDefault(t.charAt(i),0)+1);
        int hive=0,tcount=tmp.size();
        //滑动窗口
        int right=0,left=0;
        while (right<s.length()){
            //添加元素成功
            smp.put(s.charAt(right),smp.getOrDefault(s.charAt(right),0)+1);
            //判断have++完成
            if(tmp.containsKey(s.charAt(right))){
                //只有相等的时候才++，这样可以防止你重复加
                if(tmp.get(s.charAt(right)).equals(smp.get(s.charAt(right)))) {
                    hive++;
                }
            }

            //left++判断，以及定义start和res
            while (hive==tcount){
                //这里可以判断一下是否存在
                if(!tmp.containsKey(s.charAt(left))){
                    left++;
                    continue;
                }
                //此时有的，判断一下，是否相同，hive--，顺便吧smp的left数量-1
                if(smp.get(s.charAt(left)).equals(tmp.get(s.charAt(left))))hive--;
                smp.put(s.charAt(left),smp.get(s.charAt(left))-1);
                //这类考虑一个东西，如果更小，就选择更新
                if(right - left < res) {
                    start = left;
                    res = right - left;
                }
                //left边界要变化
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res+1);
    }



}
