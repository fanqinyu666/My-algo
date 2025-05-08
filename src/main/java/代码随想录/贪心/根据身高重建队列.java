package 代码随想录.贪心;

import java.util.Arrays;
import java.util.LinkedList;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）,自定义比较函数
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            //a-b 是升序排列，故在a[0] == b[0]的狀況下，根据k值升序排列
            return b[0]-a[0];
            //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
        });

        LinkedList<int[]> que = new LinkedList<>();
        //第一轮排序好，第二类根据k再次排序，需要用链表，不然频繁的插入操作，用数组肯定不入链表
        for (int[] p : people) {
            que.add(p[1],p);   //Linkedlist.add(index, value)，會將value插入到指定index裡。
        }

        return que.toArray(new int[people.length][]);
    }


}
