package 代码随想录.二叉树;

import java.util.*;

public class test {

    List<List<String>> lists=new ArrayList<> ();
    List<String> list=new ArrayList<>();

    public List<List<String>> partition(String s) {
        brack(s,new StringBuilder(),0);
        return lists;
    }


    private void brack(String s, StringBuilder stringBuilder, int start) {
        if(start==s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<s.length();i++){
            stringBuilder.append(s.charAt(i));
            if(reverse(stringBuilder)){
                list.add(stringBuilder.toString());
                brack(s,new StringBuilder(),i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean reverse(StringBuilder sb){
        int left=0,right=sb.length()-1;
        while (left<right){
            char l = sb.charAt(left);
            char r = sb.charAt(right);
            left++;
            right--;
            if(l!=r)return false;
        }
        return true;
    }

}