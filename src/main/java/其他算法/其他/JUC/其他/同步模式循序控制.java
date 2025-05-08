package 其他算法.其他.JUC.其他;

public class 同步模式循序控制 {

    final static Object lock=new Object();
    static boolean is=false;
    static int biaoji=1;

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (true) {
                        while (biaoji!=1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("1");
                        biaoji=2;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock.notifyAll();
                    }
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (true) {
                        while (biaoji!=2){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("2");
                        biaoji=3;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock.notifyAll();
                    }
                }
            }
        },"t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (true) {
                        while (biaoji!=3){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("3");
                        biaoji=1;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock.notifyAll();
                    }
                }
            }
        },"t3").start();
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
