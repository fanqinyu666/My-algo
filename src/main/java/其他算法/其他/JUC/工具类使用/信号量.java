package 其他算法.其他.JUC.工具类使用;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

public class 信号量 {
    /*
        public static void main(String[] args) {
            Semaphore semaphore = new Semaphore(3);
            for (int i = 0; i < 10; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            semaphore.acquire();
                            System.out.println("我是线程"+Thread.currentThread());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }finally {
                            semaphore.release();
                        }
                    }
                }).start();
            }
        }*/
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("我是线程" + Thread.currentThread());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        semaphore.release();
                    }
                }
            }).start();
        }
    }





}
