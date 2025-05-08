package 代码随想录.数组;

import java.util.*;

public class 滑动窗口 {
    public static void main(String[] args) {
        滑动窗口 s=new 滑动窗口();
        s.findAnagrams("cbaebabacd","abc");
    }
    //精髓就是如何移动起始位置，终止位置已经决定了就是for循环递增

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;

        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;


    }
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        HashSet set=new HashSet<Character>();
        int sum=0;
        int slow=0;
        int max=0;

        for (int fast= 0; fast<charArray.length; fast++) {
            while(set.contains(charArray[fast])){
                slow++;
                set.remove(charArray[fast]);
            }
            set.add(charArray[fast]);
            max= Math.max(fast-slow+1, max);
        }
        return max;
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max=0;
        for (int fast= 0,slow=0;fast<fruits.length; fast++)
        {
            while((!map.containsKey(fruits[fast]))&&map.size()>=2){
                int a=map.get(fruits[slow]);
                while(map.containsKey(a)){
                    slow++;
                    map.put(a,map.get(a)-1);
                    if(map.get(a)==0){
                        map.remove(a);
                    }
                }
                map.remove(fruits[slow]);

            }
            if(map.containsKey(fruits[fast])){
                map.put(fruits[fast],map.get(fruits[fast])+1);
                max= Math.max(fast-slow+1, max);
            }else{
                map.put(fruits[fast],1);
                max= Math.max(fast-slow+1, max);
            }
        }
        return max;
    }
    class Solution {
        public int totalFruit(int[] fruits) {
            int n = fruits.length;
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

            int left = 0, ans = 0;
            for (int right = 0; right < n; right++) {
                cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
                while (cnt.size() > 2) {
                    cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                    if (cnt.get(fruits[left]) == 0) {
                        cnt.remove(fruits[left]);
                    }
                    ++left;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }


        List<Integer> ans = new ArrayList<Integer>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
//cbaebabacd
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;


    }
      /*  List<Integer> ans = new ArrayList<Integer>();
        int slen = s.length();
        int plen = p.length();

        // 判不合理
        if (slen < plen) {
            return new ArrayList<Integer>();
        }

        int[] count = new int[26];
        // 用起始索引0的情况初始化count数组
        for (int i = 0; i < plen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        // 初始化differ
        int differ = 0;
        for (int j = 0; j < 26; j++) {
            if (count[j] != 0) {
                differ++;
            }
        }
        // 初始化ans
        if (differ == 0) {
            ans.add(0);
        }
        // 滑动过程，起始索引是i+1
        for (int i = 0; i < slen - plen; i++) {
            // 把左端滑出窗口，判断differ变化
            count[s.charAt(i) - 'a']--;
            if (count[s.charAt(i) - 'a'] == 0) {
                differ--;
            } else if (count[s.charAt(i) - 'a'] == -1) {
                differ++;
            }
            // 把右端滑入，判断differ变化
            count[s.charAt(i + plen) - 'a']++;
            if (count[s.charAt(i + plen) - 'a'] == 0) {
                differ--;
            } else if (count[s.charAt(i + plen) - 'a'] == 1) {
                differ++;
            }

            // 符合条件否
            if (differ == 0) {
                ans.add(i + 1);
            }
        }
        return ans;*/



}
