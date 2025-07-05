package 其他算法.其他.JUC.其他;

public class 同步模式 {

    private static volatile int biaoji=1;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                    synchronized (this) {
                        while (true) {

                            while (biaoji != 1) {
                                try {
                                    this.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println(1);
                        }
                    }

            }
        },"t1").start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (this) {
                        while(biaoji!=1){
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(1);
                        biaoji=2;
                    }
                }
            }
        },"t1").start();


        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (this) {
                        while(biaoji!=2){
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(2);
                        biaoji=3;
                    }
                }
            }
        },"t2").start();



        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (this) {
                        while(biaoji!=3){
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(3);
                        biaoji=1;
                    }
                }
            }
        },"t3").start();









    }



}
