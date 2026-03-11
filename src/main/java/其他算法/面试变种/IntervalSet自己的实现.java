package 其他算法.面试变种;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class IntervalSet自己的实现 {
    // 存放所有去重排序后的端点，作为“切分空间的刀”
    private double[] endpoints;
    // 存放原子区间桶，buckets[i] 对应原子区间 (endpoints[i], endpoints[i+1]]
    private List<String>[] buckets;

    @SuppressWarnings("unchecked")
    public IntervalSet自己的实现(double[][] intervals) {
        if (intervals == null || intervals.length == 0) return;

        //去重收集所有区间的左、右端点，用treeset为了去重+排序（HashSet不排序）
        TreeSet<Double> set = new TreeSet<>();
        for (double[] interval : intervals) {
            set.add(interval[0]);
            set.add(interval[1]);
        }
        int idx = 0;
        endpoints = new double[set.size()];
        for (double val : set)endpoints[idx++] = val;

        //初始化桶
        buckets = new ArrayList[endpoints.length - 1];
        for (int i = 0; i < buckets.length; i++)buckets[i] = new ArrayList<>();

        //填桶：把每个原始区间，塞进它覆盖的所有原子桶里
        for (double[] interval : intervals) {
            double a = interval[0];
            double b = interval[1];
            String intervalStr = "(" + a + ", " + b + "]";

            //binarySearch，找到endpoints中，a值对应下标，做二分而已
            int startIdx = Arrays.binarySearch(endpoints, a);
            int endIdx = Arrays.binarySearch(endpoints, b);

            //例如原区间跨越了 3 个原子区间，就把它分别add到这3个桶里
            for (int i = startIdx; i < endIdx; i++) {
                buckets[i].add(intervalStr);
            }
        }
    }

    /**
     * 查询函数：时间复杂度极低，仅为 O(log K)，K 为去重后的端点数，必然 < O(n)
     */
    public List<String> findIntervals(double x) {
        if (endpoints == null || endpoints.length < 2 || 
            x <= endpoints[0] || x > endpoints[endpoints.length - 1]) {
            return new ArrayList<>();
        }
        //二分找x落在哪个端点位置
        int pos = Arrays.binarySearch(endpoints, x);
        int bucketIdx;

        //x恰好等于某个端点，题目是左开右闭 (a, b]，x必然属于它左边的原子区间
        if (pos >= 0) {
            bucketIdx = pos - 1;
        } else {
            //x没命中端点，落在两个端点之间，Arrays.binarySearch 返回的是 -(插入点) - 1
            int insertionPoint = -pos - 1;
            // 插入点前面的那个原子区间，就是完全包裹 x 的桶
            bucketIdx = insertionPoint - 1;
        }

        // O(1) 的时间直接返回桶里预先准备好的 List 引用！没有任何遍历！
        return buckets[bucketIdx];
    }

    // 运行测试用例
    public static void main(String[] args) {
        double[][] data = {{0, 1}, {-1, 0}, {-1, 1}};
        IntervalSet自己的实现 set = new IntervalSet自己的实现(data);

        System.out.println("findIntervals(-1):   " + set.findIntervals(-1));     // 预期: []
        System.out.println("findIntervals(-1.1): " + set.findIntervals(-1.1));   // 预期: []
        System.out.println("findIntervals(-0.9): " + set.findIntervals(-0.9));   // 预期: [(-1.0, 0.0], (-1.0, 1.0]]
        System.out.println("findIntervals(0):    " + set.findIntervals(0));      // 预期: [(-1.0, 0.0], (-1.0, 1.0]]
        System.out.println("findIntervals(0.1):  " + set.findIntervals(0.1));    // 预期: [(0.0, 1.0], (-1.0, 1.0]]
        System.out.println("findIntervals(1):    " + set.findIntervals(1));      // 预期: [(0.0, 1.0], (-1.0, 1.0]]
        System.out.println("findIntervals(1.1):  " + set.findIntervals(1.1));    // 预期: []
    }
}