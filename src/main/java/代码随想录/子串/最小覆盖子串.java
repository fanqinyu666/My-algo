package 代码随想录.子串;

import java.util.HashMap;

public class 最小覆盖子串 {

    public String minWindow(String s, String t) {
        String res=s;
        int left=0,right=0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++)map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
        for(int i=0;i<s.length();i++)map2.put(s.charAt(i),0);

        while (right<s.length()){
            map2.put(s.charAt(right),map2.getOrDefault(s.charAt(right),0)+1);
            boolean extracted = extracted(t, map1, map2);
            if(extracted){
                if((right-left)<res.length())res=s.substring(left,right+1);
                while (left<right&&extracted(t,map1,map2)){
                    map2.put(s.charAt(left),map2.get(s.charAt(left))-1);
                    left++;
                }

            }else {
                right++;
                continue;
            }
        }
        return res;
    }

    private boolean extracted(String t, HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        boolean a=true;
        for (int i = 0; i< map1.size(); i++){
            Integer i1 = map1.get(t.charAt(i));
            Integer i2 = map2.get(t.charAt(i));
            if(i1>i2){
                a=false;
                break;
            }
        }
        return a;
    }
}
