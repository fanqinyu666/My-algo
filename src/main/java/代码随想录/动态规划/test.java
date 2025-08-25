package 代码随想录.动态规划;

public class test {

    public String longestPalindrome(String s) {
        int count=0;
        int start=0;
        for (int i=0;i<s.length();i++){
            //奇数
            int L=i,R=i;
            while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
                if(R-L+1>count){
                    //子串的起始位置
                    count=R-L+1;
                    start=L;
                }
                L--;
                R++;
            }
            //偶数
            L=i;
            R=i+1;
            while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
                if(R-L+1>count){
                    //子串的起始位置
                    count=R-L+1;
                    start=L;
                }
                L--;
                R++;
            }
        }
        return s.substring(start, start + count);
    }
}