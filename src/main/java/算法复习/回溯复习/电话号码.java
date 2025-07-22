package 算法复习.回溯复习;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 电话号码 {
    LinkedList<String> path = new LinkedList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0){
            return new ArrayList<>();
        }
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        strings.add("jkl");
        strings.add("mno");
        strings.add("pqrs");
        strings.add("tuv");
        strings.add("wxyz");

        int index=0;
        backtracking(digits,strings,index);
        return path;
    }

    private void backtracking(String digits, ArrayList<String> strings, int index) {
        if(index==digits.length()){
            path.add(temp.toString());
            return;
        }
        char c = digits.charAt(index);
        int i1 = c - '2';
        String s = strings.get(i1);
        for(int i=0;i<s.length();i++){
            temp.append(s.charAt(i));
            backtracking(digits,strings,index+1);
            temp.delete(temp.length()-1,temp.length());
        }
    }

    public static void main(String[] args) {
        电话号码 电话号码 = new 电话号码();
        电话号码.letterCombinations("23");
    }
}
