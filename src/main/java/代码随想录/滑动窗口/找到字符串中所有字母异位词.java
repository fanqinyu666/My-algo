package 代码随想录.滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int[] in1=new int[26];
        int[] in2=new int[26];
        for(int i=0;i<p.length()-1;i++)in1[s.charAt(i)-'a']++;
        for(int i=0;i<p.length();i++)in2[p.charAt(i)-'a']++;
        for(int i=p.length()-1;i<s.length();i++){
            in1[s.charAt(i)-'a']++;
            //先添加，再判断
            boolean isok=true;
            for(int j=0;j<in1.length;j++){
                if(in1[j]!=in2[j]){
                    isok=false;
                    break;
                }
            }
            if(isok)list.add(i-p.length()+1);
            //减去左边界的
            in1[s.charAt(i-p.length()+1)-'a']--;

        }

        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 边界处理
        if (sLen < pLen) return list;

        // 沿用第一种命名的风格：in1 代表窗口计数，in2 在这里简化为差值计数
        int[] in1 = new int[26];
        for (int i = 0; i < pLen; i++) {
            in1[s.charAt(i) - 'a']++;
            in1[p.charAt(i) - 'a']--;
        }

        // differ 记录 in1 数组中非零元素的个数
        int differ = 0;
        for (int j = 0; j < 26; j++)if (in1[j] != 0) differ++;

        if (differ == 0) list.add(0);

        //开始滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            // 1. 处理左边界移除的字符 (s[i])
            if (in1[s.charAt(i) - 'a'] == 1) {
                differ--; // 之前多 1，减去后变成 0，差异减少
            } else if (in1[s.charAt(i) - 'a'] == 0) {
                differ++; // 之前相等，减去后不相等，差异增加
            }
            in1[s.charAt(i) - 'a']--;

            // 2. 处理右边界移入的字符 (s[i + pLen])
            if (in1[s.charAt(i + pLen) - 'a'] == -1) {
                differ--; // 之前缺 1，加上后变成 0，差异减少
            } else if (in1[s.charAt(i + pLen) - 'a'] == 0) {
                differ++; // 之前相等，加上后不相等，差异增加
            }
            in1[s.charAt(i + pLen) - 'a']++;

            // 3. 判断当前窗口是否满足条件
            if (differ == 0) {
                list.add(i + 1);
            }
        }

        return list;
    }




}
