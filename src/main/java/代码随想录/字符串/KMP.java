package 代码随想录.字符串;

import java.util.Arrays;

public class KMP {
    //原字符串
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s + s, s);
    }

    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        //next数组采用的-1写法（右移）
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 1; i < n - 1; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern(String s, String ss) {
        int[] next = new int[s.length()];
        Arrays.fill(next, -1);//next的-1形式

        //对s构建Next数组
        for (int i = 1; i < s.length(); ++i) {
            int j = next[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = next[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                next[i] = j + 1;
            }
        }

        int match = -1;
        // 2. 在 ss 中搜索 s，范围限制在 [1, ss.length() - 2]
        for (int i = 1; i < ss.length() - 1; ++i) {
            while (match != -1 && s.charAt(match + 1) != ss.charAt(i)) {
                match = next[match];
            }
            if (s.charAt(match + 1) == ss.charAt(i)) {
                ++match;
                // 如果匹配长度达到了 s 的长度，说明找到了
                if (match == s.length() - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
