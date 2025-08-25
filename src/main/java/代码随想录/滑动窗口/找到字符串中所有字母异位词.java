package 代码随想录.滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        //p比s长，下面要报越界
        if(p.length()>s.length()){
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        int[] si=new int[26];
        int[] pi=new int[26];

        for(int i=0;i<p.length();i++){
            char x= p.charAt(i);
            pi[x-'a']++;
        }

        for(int i=0;i<p.length()-1;i++){
            //这里
            char x= s.charAt(i);
            si[x-'a']++;
        }

        int left=0,right=p.length()-1;

        while(right<s.length()){
            boolean q=true;

            char c=s.charAt(right);
            si[c-'a']++;
            for(int i=0;i<26;i++){
                if(si[i]!=pi[i]){
                    q=false;
                    break;
                }
            }
            if(q){
                arrayList.add(left);
            }
            char l=s.charAt(left++);
            si[l-'a']--;
            right++;
        }
        return arrayList;
    }




}
