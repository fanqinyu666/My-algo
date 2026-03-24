package 其他算法.JUC.JUC设计模式.同步模式;


public class H2O {

    public static volatile int water =0;
    public static volatile int orf =0;
    public final static Object lock=new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        while (water==2){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("water+1");
                        water++;
                        lock.notifyAll();
                    }
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        while (orf==1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("orf+1");
                        orf++;
                        lock.notifyAll();
                    }
                }
            }
        },"t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        while (water!=2||orf!=1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        water=0;
                        orf=0;
                        System.out.println("H2O");

                        lock.notifyAll();
                    }
                }
            }
        },"t3").start();

    }
}
