package 代码随想录.堆_优先队列;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }

/*

    PriorityQueue<Integer> queMin;  // 最小堆（存较大半部分）
    PriorityQueue<Integer> queMax;  // 最大堆（存较小半部分）

    public MedianFinder() {
        queMin = new PriorityQueue<>();  // 默认最小堆
        queMax = new PriorityQueue<>((a,b)->b-a);  // 自定义最大堆
    }

    public void addNum(int num) {
        // 先加入对应堆
        if(queMax.isEmpty() || num <= queMax.peek()){
            queMax.offer(num);
        }else{
            queMin.offer(num);
        }

        // 平衡堆大小（保持queMax.size >= queMin.size）
        if(queMax.size() > queMin.size()+1){
            queMin.offer(queMax.poll());
        }else if(queMin.size() > queMax.size()){
            queMax.offer(queMin.poll());
        }
    }

    public double findMedian() {
        return queMax.size() > queMin.size()
                ? queMax.peek()
                : (queMax.peek() + queMin.peek())/2.0;
    }
*/

}