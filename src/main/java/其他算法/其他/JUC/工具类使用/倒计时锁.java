package 其他算法.其他.JUC.工具类使用;

import java.util.concurrent.CountDownLatch;

public class 倒计时锁 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1结束");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2结束");
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程3结束");

            }
        }).start();
        try {
            countDownLatch.await();
            System.out.println("执行到这里了");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
