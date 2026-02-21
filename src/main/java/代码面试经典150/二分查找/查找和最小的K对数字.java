package 代码面试经典150.二分查找;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //传入的是两个数组，o1和o2，每个数组长度为2，下标0是nums1选择的元素，下标1是nums2选择的元素。这俩相加作比较，构建最小堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        //初始化，相当于nums1【0-i】，nums2【0】
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            //其实就是一个长为2的集合
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            //nums1【0-i】不变，nums2【j】+1，这个j初始一直是0，如果就绪队列里这个idxpair【1】+1《n（比nums2的长度小，没有越界，就往堆里加入这个元素）
            if (idxPair[1] + 1 < n)pq.offer(new int[]{idxPair[0], idxPair[1] + 1});

        }

        return ans;
    }

}
