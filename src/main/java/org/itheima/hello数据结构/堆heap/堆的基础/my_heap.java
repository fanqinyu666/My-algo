package org.itheima.hello数据结构.堆heap.堆的基础;

import java.util.List;

public class my_heap {
    //优先队列就是堆
    private List<Integer> maxHeap;

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
