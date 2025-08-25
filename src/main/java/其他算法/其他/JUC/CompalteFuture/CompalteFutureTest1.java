package 其他算法.其他.JUC.CompalteFuture;

import java.util.concurrent.*;

public class CompalteFutureTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Void也是一个类，逆天了
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("666");
        });
        //这里就是返回null
        System.out.println(future.get());


        //用自己的线程池，代替他forkjoin内部线程池
        ExecutorService threadPool= Executors.newFixedThreadPool(1);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(()->{
            System.out.println("666");
        },threadPool);



    }
}
