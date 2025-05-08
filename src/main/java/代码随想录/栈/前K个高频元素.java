package 代码随想录.栈;

import java.util.*;

public class 前K个高频元素 {
    public static void main(String[] args) {
        前K个高频元素 前K个高频元素 = new 前K个高频元素();

        前K个高频元素.topKFrequent(new int[]{3,0,1,0},1);

    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //定义一个优先队列，是一个小顶堆，用lambda的简化，实现compare函数，也就是一个排序方式
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { //小顶堆只需要维持k个元素有序
            if (pq.size() < k) { //小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) { //当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll(); //弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) { //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }



    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //传入一个Comparator接口的实现类。我们匿名内部类写
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (Map.Entry entry:map.entrySet()) {
            int[] ints = new int[2];
            ints[0]=(int)entry.getKey();
            ints[1]=(int)entry.getValue();
            if(pq.size()<k){
                pq.add(ints);
            }else {
                if ((int)entry.getValue()>pq.peek()[1]) {
                    pq.poll();
                    pq.add(ints);
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) { //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}