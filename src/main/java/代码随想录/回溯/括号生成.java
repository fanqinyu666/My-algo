package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 括号生成 {
    String[] strings=new String[]{"{","}"};
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTracking(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backTracking(StringBuilder stringBuilder,int left,int right,int n) {
        if(stringBuilder.length()==2*n){
            res.add(stringBuilder.toString());
            return;
        }
        //第一个一定走左
        if (left < n) {
            stringBuilder.append('(');
            backTracking(stringBuilder, left + 1, right, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        //第二个可以右
        if (right < left) {
            stringBuilder.append(')');
            backTracking(stringBuilder, left, right + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
