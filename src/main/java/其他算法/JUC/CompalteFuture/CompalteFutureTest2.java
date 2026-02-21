package 其他算法.JUC.CompalteFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompalteFutureTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //supply供给性，没有入参，得到还参
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("666");
            return "ssa";
        });
        System.out.println(future.get());


        //用自己的线程池，代替他forkjoin内部线程池
        ExecutorService threadPool= Executors.newFixedThreadPool(1);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("666");
            return "ssa";
        },threadPool);



    }
}
