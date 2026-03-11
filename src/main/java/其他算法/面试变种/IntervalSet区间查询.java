package 其他算法.面试变种;

import java.util.*;

public class IntervalSet区间查询 {
    public static class Interval {
        double start;
        double end;

        public Interval(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + "]";
        }
    }
    // 存储排序去重后的所有端点
    private final double[] endpoints;
    // 存储每个基础区域对应的区间列表
    private final List<List<Interval>> regionIntervals;

    public IntervalSet区间查询(List<Interval> intervals) {
        // 1. 提取所有端点，利用 TreeSet 进行去重和自动排序
        TreeSet<Double> set = new TreeSet<>();
        for (Interval interval : intervals) {
            set.add(interval.start);
            set.add(interval.end);
        }

        // 2. 将端点转换为数组，方便后续 O(1) 索引和二分查找
        endpoints = new double[set.size()];
        int index = 0;
        for (double val : set) {
            endpoints[index++] = val;
        }

        // 3. 准备基础区域的存储空间 (m 个端点将数轴分为 m + 1 个区域)
        regionIntervals = new ArrayList<>(endpoints.length + 1);
        for (int i = 0; i <= endpoints.length; i++) {
            regionIntervals.add(new ArrayList<>());
        }

        // 4. 将每个原区间映射注册到它所覆盖的“基础区域”中
        for (Interval interval : intervals) {
            int startIdx = bisectLeft(endpoints, interval.start);
            int endIdx = bisectLeft(endpoints, interval.end);

            // 因为区间是左开右闭 (a, b]，它刚好完美覆盖 (startIdx, endIdx] 对应的区域
            for (int i = startIdx + 1; i <= endIdx; i++) {
                regionIntervals.get(i).add(interval);
            }
        }
    }

    /**
     * 查询阶段
     * 时间复杂度: O(log n)
     */
    public List<Interval> findIntervals(double x) {
        if (endpoints.length == 0) {
            return Collections.emptyList();
        }

        // 用二分查找找到 x 所属的基础区域索引
        int idx = bisectLeft(endpoints, x);

        // 直接返回预先计算好的列表，耗时 O(1)
        return regionIntervals.get(idx);
    }

    /**
     * 辅助方法：二分查找寻找第一个 大于或等于 target 的元素的索引
     */
    private int bisectLeft(double[] arr, double target) {
        int left = 0;
        int right = arr.length; // 注意 upper bound 是 length
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid; // 向左收缩，寻找下界
            }
        }
        return left;
    }

    // --- 测试代码 ---
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(0, 1),
                new Interval(-1, 0),
                new Interval(-1, 1)
        );

        IntervalSet区间查询 intervalSet = new IntervalSet区间查询(intervals);

        double[] testPoints = {-1, -1.1, -0.9, 0, 0.1, 1, 1.1};

        for (double x : testPoints) {
            List<Interval> result = intervalSet.findIntervals(x);
            System.out.printf("findIntervals(%5.1f): %s\n", x, result);
        }
    }
}