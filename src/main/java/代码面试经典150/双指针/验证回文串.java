package 代码面试经典150.双指针;

public class 验证回文串 {

    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while (l<r){
            //跳过左边的非字母数字字符
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            // 跳过右边的非字母数字字符
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            //小写比较是否一样
            if (Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            }else return false;
        }
        return true;
    }

}
