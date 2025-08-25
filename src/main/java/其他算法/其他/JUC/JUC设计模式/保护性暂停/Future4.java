package 其他算法.其他.JUC.JUC设计模式.保护性暂停;

import java.util.concurrent.FutureTask;

public class Future4 {

    public static void main(String[] args) throws InterruptedException {
        guardObject guardObject = new guardObject();
        new Thread(new FutureTask(()->{
            return 111;
        }));
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

        public void complaye(Future3.guardObject guardObject) {
            synchronized (this) {
                res = new Object();
                notifyAll();
                System.out.println("来了");
            }
        }
    }

}
