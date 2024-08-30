package org.itheima.hello数据结构.堆heap.堆的基础;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class heap {
    public static void main(String[] args) {
        /* 初始化堆 */

    // 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();

    // 初始化大顶堆（使用 lambda 表达式修改 Comparator 即可）
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        /* 元素入堆 */
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);

        /* 获取堆顶元素 */
        int peek = maxHeap.peek(); // 5

        /* 堆顶元素出堆 */
    // 出堆元素会形成一个从大到小的序列
        peek = maxHeap.poll(); // 5
        peek = maxHeap.poll(); // 4
        peek = maxHeap.poll(); // 3
        peek = maxHeap.poll(); // 2
        peek = maxHeap.poll(); // 1

        /* 获取堆大小 */
        int size = maxHeap.size();

        /* 判断堆是否为空 */
        boolean isEmpty = maxHeap.isEmpty();

        /* 输入列表并建堆 */
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5, 4));
    }
}
