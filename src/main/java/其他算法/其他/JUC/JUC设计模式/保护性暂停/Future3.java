package 其他算法.其他.JUC.JUC设计模式.保护性暂停;

public class Future3 {

    public static void main(String[] args) throws InterruptedException {
        guardObject guardObject = new guardObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                guardObject.get(4);
            }
        }).start();

        Thread.sleep(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                guardObject.complaye(guardObject);
            }
        }).start();


    }
    //我这个也很不错哦
    static class guardObject {
        static Object res;
        public void get(long time) {
            synchronized (this) {
                long used=0;
                while (res == null) {
                    if(used>=time){
                        System.out.println("超时了");
                        break;
                    }
                    long start=System.currentTimeMillis();
                    try {
                        wait(time-used);
                    } catch (InterruptedException e) {
                        System.out.println("还没来");
                    }
                    used+=System.currentTimeMillis()-start;
                }
            }
        }

        public void complaye(guardObject guardObject) {
            synchronized (this) {
                res = new Object();
                notifyAll();
                System.out.println("来了");
            }
        }
    }
}

