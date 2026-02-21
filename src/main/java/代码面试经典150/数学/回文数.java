package 代码面试经典150.数学;

import 代码面试经典150.二分查找.搜索二维矩阵;

import java.util.Stack;

public class 回文数 {
    public boolean isPalindrome3(int x) {
        String s = String.valueOf(x);
        int left=0,right=s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome2(int x) {
        int first=x;
        int second=0;
        while (x>0){
            int ss = x % 10;
            second=second*10+ss;
            x=x/10;
        }
        return first==second;
    }

    public boolean isPalindrome(int x) {
        int second=0;
        while (x>second){
            int ss = x % 10;
            second=second*10+ss;
            x=x/10;
        }
        return x==second||second/10==x;
    }

}
