package 其他算法.JUC.CompalteFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompalteFutureTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //supply供给性，没有入参，得到还参
        CompletableFuture.supplyAsync(() -> {
            System.out.println("666");
            try {Thread.sleep(500);} catch (InterruptedException e) {throw new RuntimeException(e);}
            return 333;
        //需要俩入参，一个是上一阶段的返回值，一个是可能出现的异常
        }).whenComplete((v,e)->{
            if(e==null){
                System.out.println(v+"成功");
            }
        //如果出现异常第一步
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("有异常");
            return null;
        });

        System.out.println("线程先去干别的");
        Thread.sleep(1000);
        //CompletableFuture默认的线程池会在主线程结束的时候结束，所以我们最好延迟，或者用自己的线程池
    }
}
