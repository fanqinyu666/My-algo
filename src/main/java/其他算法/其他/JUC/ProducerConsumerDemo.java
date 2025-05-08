package 其他算法.其他.JUC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private volatile boolean productionStopped = false;
    private static final int BUFFER_CAPACITY = 10;

    // 生产者线程
    class Producer implements Runnable {
        private final int totalProducts;

        public Producer(int total) {
            this.totalProducts = total;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= totalProducts; i++) {
                    lock.lock();
                    try {
                        // 等待缓冲区有空位
                        while (buffer.size() == BUFFER_CAPACITY) {
                            notFull.await();
                        }
                        
                        buffer.offer(i);
                        System.out.println("生产: " + i);
                        notEmpty.signalAll(); // 唤醒所有消费者
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(1000); // 每秒生产一个
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 生产完成后设置停止标志
                lock.lock();
                try {
                    productionStopped = true;
                    notEmpty.signalAll(); // 唤醒所有等待的消费者
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // 消费者线程
    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        // 等待缓冲区有数据或生产停止
                        while (buffer.isEmpty() && !productionStopped) {
                            notEmpty.await();
                        }
                        
                        // 终止条件：缓冲区空且生产已停止
                        if (buffer.isEmpty() && productionStopped) {
                            break;
                        }
                        
                        // 消费数据
                        Integer item = buffer.poll();
                        System.out.println(Thread.currentThread().getName() + " 消费: " + item);
                        notFull.signal(); // 唤醒生产者
                    } finally {
                        lock.unlock();
                    }
                    
                    // 模拟消费耗时
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
/*
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerDemo demo = new ProducerConsumerDemo();
        
        // 创建生产者（生产10个产品）
        Thread producer = new Thread(demo.new Producer(10), "Producer");
        
        // 创建3个消费者
        Thread[] consumers = new Thread;
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(demo.new Consumer(), "Consumer-" + (i+1));
        }

        // 启动所有线程
        producer.start();
        for (Thread consumer : consumers) {
            consumer.start();
        }

        // 等待所有线程结束
        producer.join();
        for (Thread consumer : consumers) {
            consumer.join();
        }
        
        System.out.println("全部生产和消费完成");
    }*/
}
