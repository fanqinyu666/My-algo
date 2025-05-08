package 其他算法.其他.JUC.工具类使用;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 同步等待多线程准备 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Random random = new Random();
        String[] strings = new String[10];

        for (int j = 0; j < 10; j++) {
            int finalJ = j;
            executorService.submit(()->{
                for (int i = 0; i <=100; i++) {
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    strings[finalJ]=i+"%";
                    System.out.print("\r"+Arrays.toString(strings));//好好玩啊！
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            System.out.println("\r"+"王者荣耀，启动！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
