package 其他算法.其他.JUC;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁 {
    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                dataContainer.read();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                dataContainer.write();
            }
        }).start();

    }

    static class DataContainer {
        //读写锁保护对象
        private Object data;
        public static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
        //读锁和写锁是读写锁的内部类
        public static ReentrantReadWriteLock.ReadLock r = rw.readLock();
        public static ReentrantReadWriteLock.WriteLock w = rw.writeLock();

        public void read() {
            r.lock();
            try {
                System.out.println("获取读锁");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                r.unlock();

            }
        }

        public void write() {
            w.lock();
            try {
                System.out.println("获取写锁");
            } finally {
                w.unlock();
            }

        }
    }
}