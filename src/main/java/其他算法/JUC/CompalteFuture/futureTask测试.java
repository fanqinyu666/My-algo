package 其他算法.JUC.CompalteFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class futureTask测试 {
    public static void main(String[] args) {
        //FutureTask继承了Future，Runnable
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("111");
                return 111;
            }
        });

        Thread thread = new Thread(integerFutureTask);
        thread.start();

        try {
            //尝试获取
            integerFutureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //会阻塞，设置超时时间不优雅
    }
}
