package 算法复习.复习1;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {

    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return res;
    }

    private void backtracking(String s, int start, StringBuilder stringBuilder) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i++){
            stringBuilder.append(s.charAt(i));
            if (check(stringBuilder)){
                cur.add(stringBuilder.toString());
                backtracking(s, i + 1, new StringBuilder());
                cur.remove(cur.size() -1 );
            }
        }

    }


    private boolean check(StringBuilder sb){
        for (int i = 0; i < sb.length()/ 2; i++){
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){return false;}
        }
        return true;
    }
}
