package 其他算法.JUC.JUC设计模式.保护性暂停;

import java.sql.Time;

public class Future5 {
    public static void main(String[] args) throws InterruptedException {
        Future3.guardObject guardObject = new Future3.guardObject();
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
}
class guardObject {
    public Object response;
    public Object get(long timeout){

        synchronized (this){
            //初始时间
            long begin = System.currentTimeMillis();
            while (response==null) {
                if(timeout<=0)break;
                try {
                    this.wait(timeout);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long end = System.currentTimeMillis();
                timeout-=end-begin;
            }
            return response;
        }
    }
    public void set(Object res){
        synchronized (this){
            this.response=res;
            this.notifyAll();
        }
    }
}