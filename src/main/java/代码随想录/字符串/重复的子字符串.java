package 代码随想录.字符串;

public class 重复的子字符串 {

    public static void main(String[] args) {
        重复的子字符串 重复的子字符串 = new 重复的子字符串();
        重复的子字符串.repeatedSubstringPattern(new String("aba"));
    }
    public boolean repeatedSubstringPattern(String s) {
        String string = s + s;
        String substring = string.substring(1, s.length() *2-1);
        int i = substring.indexOf(s);
        if(i!=-1){
            return true;
        }
        return false;
    }




}
