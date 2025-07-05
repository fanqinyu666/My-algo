package 其他算法.其他.JUC.JUC设计模式.生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class 生产者消费者 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {

            }
        });
        Buffer buffer = new Buffer(5);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        Thread thread = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread.start();
        thread2.start();
    }

    private static class Buffer{
        public Buffer(int size) {
            this.size = size;
        }

        int size=5;
        private BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<>();
        private synchronized void add(int i) throws InterruptedException {
            if (blockingQueue.size()>=size)
                wait();
            blockingQueue.add(i);
            notify();
        }

        private synchronized void remove() throws InterruptedException {
            if (blockingQueue.size()==0)
                wait();
            Integer remove = blockingQueue.remove();
            notify();
            System.out.println(remove);
        }

    }
    private static class Producer implements Runnable{
        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }
        private Buffer buffer;
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.add(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }
        private Buffer buffer;
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.remove();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
