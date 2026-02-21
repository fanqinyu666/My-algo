package 其他算法.JUC.其他;

public class 同步模式顺序控制3 {

    private static final Object lock=new Object();
    private static Integer status=1;


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock){
                        //一会处理虚假唤醒
                        while (status!=1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                System.out.println("唤醒了");
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(1);
                        status=2;
                        lock.notifyAll();
                    }
                }
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock){
                        //一会处理虚假唤醒
                        while (status!=2){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                System.out.println("唤醒了");
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(2);
                        status=3;
                        lock.notifyAll();
                    }
                }
            }
        },"t2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock){
                        //一会处理虚假唤醒
                        while (status!=3){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                System.out.println("唤醒了");
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(3);
                        status=1;
                        lock.notifyAll();
                    }
                }
            }
        },"t3").start();

    }


}
