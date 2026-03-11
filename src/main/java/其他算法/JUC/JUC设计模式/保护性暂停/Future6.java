package 其他算法.JUC.JUC设计模式.保护性暂停;

public class Future6 {

    public static void main(String[] args) {
        ObjectGuard objectGuard = new ObjectGuard();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (objectGuard) {
                    objectGuard.isok = false;
                    objectGuard.notifyAll();
                }
                System.out.println("fin2");
            }
        }).start();

        objectGuard.get(1000);
    }

    public static class ObjectGuard{

        public volatile boolean isok=true;

        public void get(long time){
            synchronized (this){
                long begin = System.currentTimeMillis();

                while (isok){
                    if (time<0)break;
                    try {
                        this.wait(time);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    time-=System.currentTimeMillis()-begin;
                }
                System.out.println("fin");
            }
        }

    }


}
