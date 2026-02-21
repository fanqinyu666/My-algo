package 其他算法.JUC.面试;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
//对啊，我怎么忘了用原子类
public class 三生二消五缓十任 {
    public class ProducerConsumerPattern {
        // 队列大小为 5
        private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        // 目标消费总数
        private static final int TOTAL_TASKS = 10;
        // 记录已消费的任务数
        private static final AtomicInteger consumedCount = new AtomicInteger(0);
        // 结束信号（毒丸对象）
        private static final Integer POISON_PILL = -1;

        public static void main(String[] args) {
            // 1. 创建 3 个生产者
            for (int i = 1; i <= 3; i++) {
                new Thread(new Producer(i), "Producer-" + i).start();
            }

            // 2. 创建 2 个消费者
            for (int i = 1; i <= 2; i++) {
                new Thread(new Consumer(i), "Consumer-" + i).start();
            }
        }

        // 生产者逻辑
        static class Producer implements Runnable {
            private final int id;

            Producer(int id) {
                this.id = id;
            }

            @Override
            public void run() {
                try {
                    while (consumedCount.get() < TOTAL_TASKS) {
                        int item = (int) (Math.random() * 100);
                        // put 方法在队列满时会自动阻塞
                        queue.put(item);
                        System.out.println(Thread.currentThread().getName() + " 生产了: " + item);
                        Thread.sleep(200); // 模拟生产耗时
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // 消费者逻辑
        static class Consumer implements Runnable {
            private final int id;

            Consumer(int id) {
                this.id = id;
            }

            @Override
            public void run() {
                try {
                    while (true) {
                        // take 方法在队列为空时会自动阻塞
                        Integer item = queue.take();

                        // 检查是否已达到消费上限
                        int currentCount = consumedCount.incrementAndGet();
                        if (currentCount <= TOTAL_TASKS) {
                            System.out.println(Thread.currentThread().getName() + " 消费了: " + item + " (总进度: " + currentCount + "/" + TOTAL_TASKS + ")");
                            Thread.sleep(500); // 模拟消费耗时
                        }

                        if (currentCount >= TOTAL_TASKS) {
                            System.out.println(Thread.currentThread().getName() + " 任务完成，准备退出...");
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
