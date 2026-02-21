package 其他算法.JUC;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class test2 {
    public static volatile int num=0;
    public static final Object locks=new Object();
    public static final Object lockx=new Object();
    public static void main(String[] args) {
        BlockingDeque<Integer> integers = new LinkedBlockingDeque<>(5);
        for (int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (locks) {
                            if (num >= 10) break;
                        }
                        try {
                            integers.put(1); // 阻塞等待空间，不要放在锁块里
                            synchronized (locks) {
                                if (num < 10) {
                                    num++;
                                    System.out.println("生产后总数: " + num);
                                } else {
                                    // 如果阻塞期间别人已经产满了，就把刚才放进去的拿出来（可选）
                                    // 或者更简单的做法是把 num++ 放在 put 之前
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // 使用 poll 带超时，防止生产者结束后消费者死等
                            Integer item = integers.poll(500, TimeUnit.MILLISECONDS);

                            synchronized (lockx) {
                                // 队列空且生产已达标，退出
                                if (item == null && num >= 10) break;

                                if (item != null) {
                                    System.out.println("消费成功，剩余库存: " + integers.size());
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
