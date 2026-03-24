package 算法复习_随手练.小练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1 {
    static ArrayList<String> lists=new ArrayList<>();
    static ArrayList<Character> list=new ArrayList<>();

    public static ArrayList<String> get(List<String> sqs){
        brack(sqs,0);
        return lists;
    }

    private static void brack(List<String> sqs,int index) {
        if(lists.size()==index){
            lists.add(list.toString());
            return;
        }
        for (int i = 0; i < sqs.get(index).length(); i++) {
            list.add(sqs.get(index).charAt(i));
            brack(sqs,index+1);
            list.remove(list.size()-1);
        }
    }


}