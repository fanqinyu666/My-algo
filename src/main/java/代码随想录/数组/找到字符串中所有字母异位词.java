package 代码随想录.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()){
            return new ArrayList();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] ints = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ints[p.charAt(i)-'a']++;
        }

        int[] res = new int[26];
        int left=0,right=p.length()-1;
        for (int i = 0; i <=right; i++) {
            res[s.charAt(i)-'a']++;
        }

        while (right<s.length()){
            int no =0;
            for (int i = 0; i < ints.length; i++) {
                if(ints[i]!=res[i]){
                    no =1;
                    break;
                    //只要有一个不同
                }
            }
            if(no ==0){
                arrayList.add(left);
            }
            if(right==s.length()-1) break;
            right++;
            res[s.charAt(right)-'a']++;
            res[s.charAt(left)-'a']--;
            left++;
        }
        return arrayList;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
