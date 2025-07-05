package 代码随想录.字符串;

public class 反转字符串单词 {

    public String reverseWords(String s) {
        // 使用双指针法！
        int m = s.length() - 1;
        StringBuilder str = new StringBuilder();
        // 除去尾部空格
        while (s.charAt(m) == ' ' && m > 0) m--;
        int n = m;
        //n是另一个指针
        while (m >= 0) {
            while (m >= 0 &&s.charAt(m) != ' ') m--;
            str.append(s.substring(m+1,n-m)+' ');
            // 获取单词并加上空格
            while (m >= 0 && s.charAt(m) == ' ') m--;
            n = m;
        }
        return str.substring(0, str.length() - 1);
        // 忽略最后一位的空格

    }

}




