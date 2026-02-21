package 其他算法.JUC.其他;

public class 同步模式循序控制2 {

    private static final Object lock=new Object();
    private static int task=1;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (task != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                        System.out.println(1);
                        task = 2;
                        lock.notifyAll();
                    }
                }
            }
        },"thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (task != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(2);
                        task = 3;
                        lock.notifyAll();
                    }
                }
            }
        },"thread2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (task != 3) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(3);
                        task = 1;
                        lock.notifyAll();
                    }
                }
            }
        },"thread3").start();
    }




/*


    public static void main(String[] args) {
    //先打印2再打印1
    new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (lock){
                if(!is){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("1");
            }

        }
    },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("2");
                    is=true;
                    lock.notify();
                }

            }
        },"t2").start();

*/


}
