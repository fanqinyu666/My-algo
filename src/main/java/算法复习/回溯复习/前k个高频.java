package 算法复习.回溯复习;

import java.util.*;

public class 前k个高频 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> integers = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerEntry : map.entrySet()) {
            integers.add(new int[]{integerEntry.getKey(), integerEntry.getValue()});
        }
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }


}
