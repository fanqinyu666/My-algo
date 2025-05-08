package 其他算法.其他.JUC.其他;

public class WaitAndNotify {
    static final Object room=new Object();
    static  boolean hasYan=false;
    static  boolean hasTakeOut=false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (room){
                    System.out.println("有烟没");
                    if(!hasYan){
                        try {
                            System.out.println("没有烟，休息会");
                            room.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if(hasYan) {
                        System.out.println("有烟了，开始工作");
                    }
                }
            }
        },"小南").start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (room) {
                        System.out.println("干活");
                    }
                }
            },"其他人").start();

        }
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (room) {
                    System.out.println("烟来了");
                    hasYan=true;
                    room.notifyAll();
                }
            }
        },"送烟").start();

    }

}
