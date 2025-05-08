package 代码随想录.贪心;

import org.itheima.hello数据结构.数组与链表.列表.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 划分字母区间 {
    
    
    public List<Integer> partitionLabels(String s) {

        LinkedList<Integer> list = new LinkedList<>();
        int[] hash = new int[26];
        int max=0;
        int last=-1;
        for (int i = 0; i < s.length(); i++) {
            int l = s.charAt(i) - 'a';
            hash[l]=i;
        }

        for (int i = 0; i < s.length(); i++) {
            int hash1 = hash[s.charAt(i) - 'a'];
            max = Math.max(hash1, max);
            if(max==i){
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }



}
