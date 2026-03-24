package 其他算法.JUC.JUC设计模式.同步模式;

public class test {
    private static volatile int water=0;
    private static volatile int ofr=0;
    private static final Object lock=new Object();
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
                        while (ofr==1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        ofr++;
                        lock.notifyAll();
                    }
                }

            }
        },"t2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    while (water!=2||ofr!=1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    water=0;
                    ofr=0;
                    lock.notifyAll();
                }
            }
        },"t3").start();
    }

}
