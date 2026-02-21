package 其他算法.JUC.CompalteFuture;

import java.util.concurrent.*;

public class future加线程池 {

    public static void main(String[] args) {

        ExecutorService threadPool=Executors.newFixedThreadPool(3);

        FutureTask<Integer> future1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("111");
                return 111;
            }
        });
        FutureTask<Integer> future2 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("111");
                return 111;
            }
        });
        FutureTask<Integer> future3 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("111");
                return 111;
            }
        });
        threadPool.submit(future1);
        threadPool.submit(future2);
        threadPool.submit(future3);

        try {
            future1.get();
            future2.get();
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
