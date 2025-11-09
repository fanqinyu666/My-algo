package 面试经典150.数组字符串;

public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;

        for (; index >= 0; index--) {
            char c = s.charAt(index);
            if (c != ' ') break;
        }
        int right = index;
        for (; index >= 0; index--) {
            char c = s.charAt(index);
            if (c == ' ') break;
        }
        return right-index;
    }
}
