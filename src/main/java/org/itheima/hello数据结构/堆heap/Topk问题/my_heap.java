package org.itheima.hello数据结构.堆heap.Topk问题;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class my_heap {
    private List<Integer> maxHeap;

    /* 基于堆查找数组中最大的 k 个元素 */
    Queue<Integer> topKHeap(int[] nums, int k) {
        // 初始化小顶堆

        Queue<Integer> heap=new PriorityQueue<Integer>();


        // 将数组的前 k 个元素入堆
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        // 从第 k+1 个元素开始，保持堆的长度为 k
        for (int i = k; i < nums.length; i++) {
            // 若当前元素大于堆顶元素，则将堆顶元素出堆、当前元素入堆
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap;
    }

    /* 构造方法，根据输入列表建堆 */
    void MaxHeap(List<Integer> nums) {
        // 将列表元素原封不动添加进堆
        maxHeap = new ArrayList<>(nums);
        // 堆化除叶节点以外的其他所有节点
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
            //从上到下堆化
        }
    }

    boolean isEmpty(){
        return maxHeap.isEmpty();
    }
    int size(){
        return maxHeap.size();
    }

    void swap(int i,int p){
        int a;
        int ii = maxHeap.get(i);
        int pp = maxHeap.get(p);
        a=ii;
        maxHeap.set(i,pp);
        maxHeap.set(p,a);
    }

    /* 获取左子节点的索引 */
    int left(int i) {
        return 2 * i + 1;
    }

    /* 获取右子节点的索引 */
    int right(int i) {
        return 2 * i + 2;
    }

    /* 获取父节点的索引 */
    int parent(int i) {
        return (i - 1) / 2; // 向下整除
    }


    /* 访问堆顶元素 */
    int peek() {
        return maxHeap.get(0);
    }


    /* 元素入堆 */
    void push(int val) {
        // 添加节点
        maxHeap.add(val);
        // 从底至顶堆化
        siftUp(size() - 1);
    }

    //给定元素 val ，我们首先将其添加到堆底。添加之后，
    // 由于 val 可能大于堆中其他元素，堆的成立条件可能
    // 已被破坏，因此需要修复从插入节点到根节点的路径上
    // 的各个节点，这个操作被称为堆化（heapify）。

    /* 从节点 i 开始，从底至顶堆化 */
    void siftUp(int i) {

        while (true) {
            // 获取节点 i 的父节点
            int p = parent(i);
            // 当“越过根节点”或“节点无须修复”时，结束堆化
            if (p < 0 || maxHeap.get(i) <= maxHeap.get(p))
                break;
            // 交换两节点
            swap(i, p);
            // 循环向上堆化
            i = p;
        }
    }

    /* 元素出堆 */
    int pop() {
        // 判空处理
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        // 交换根节点与最右叶节点（交换首元素与尾元素）
        swap(0, size() - 1);

        // 删除节点
        int val = maxHeap.remove(size() - 1);

        // 从顶至底堆化
        siftDown(0);

        // 返回堆顶元素
        return val;
    }

    /* 从节点 i 开始，从顶至底堆化 */
    void siftDown(int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = left(i), r = right(i), ma = i;
            if (l < size() && maxHeap.get(l) > maxHeap.get(ma))
                ma = l;
            if (r < size() && maxHeap.get(r) > maxHeap.get(ma))
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            swap(i, ma);
            // 循环向下堆化
            i = ma;
        }
    }

}
