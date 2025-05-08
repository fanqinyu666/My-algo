package 其他算法.其他.JUC.其他;

public class 死锁写一个玩 {

    static final Object lockA=new Object();
    static final Object lockB=new Object();

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lockB){
                        System.out.println(666);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lockA){
                        System.out.println(666);
                    }
                }
            }
        }).start();

    }


}
