package 算法复习.回溯复习;

import java.util.LinkedList;
import java.util.List;

public class 括号生成 {

    LinkedList<String> path = new LinkedList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return path;
    }
    public void backtrack(StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            path.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack( cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack( cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
