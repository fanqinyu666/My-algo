package 算法复习.回溯复习;

import java.util.ArrayList;
import java.util.List;

public class 复原ip地址 {
    List<String> res = new ArrayList<>();


    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        backtracking(s, 0,0);
        return res;
    }
    private void backtracking(String s, int startindex,int pointNum){
        if (pointNum==3){
            if (isValid(s,startindex,s.length()-1)) {
                res.add(s);
            }
            return;
        }
        //像前两题一样从前往后搜索，如果发现回文，进入backtracking,起始位置后移一位，循环结束照例移除cur的末位
        for (int i = startindex; i < s.length(); i++){
            //判断条件
            if (isValid(s,startindex,i)){
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backtracking(s, i + 2,pointNum);
                //i+2,这里加2是因为，加了一个逗点的长度
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
                // 回溯删掉逗点

            }else {
                break;
            }
        }
    }

    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            // 0开头的数字不合法
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
