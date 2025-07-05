package 其他算法.其他.JUC.JUC设计模式.保护性暂停;

//保护性暂停代码
public class Futrue {
    //线程1等待线程2的任务
    public static void main(String[] args) throws InterruptedException {

        GuardedObject2 guardedObject = new GuardedObject2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("下载中");
                Object o = guardedObject.get();
                System.out.println(o.toString());
            }
        }).start();
        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                guardedObject.comlete("完成啦");
            }
        }).start();
    }

}

//不带超时时间
class GuardedObject{
    private Object response;

    public Object get(){
        synchronized (this){
            while (response==null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return response;
        }
    }



    public void comlete(Object response){
        synchronized (this){
            this.response=response;
            this.notifyAll();
        }
    }

}


//带超时时间的
class GuardedObjectTimed{
    //带超时时间的futrue
    private Object response;
    //传入2000就是等2s
    //你这里不能直接传入参数，不然出来也会进入下一轮循环

    public Object get(long timeout){

        synchronized (this){
            //记录开始时间
            long begin=System.currentTimeMillis();
            long passedTime=0;
            while (response==null){
                //经历的时间超过最大时间了
                if(passedTime>=timeout){
                    break;
                }
                try {
                    //比如2s，你第一轮被虚假唤醒，已经等了1s，你第二轮再等2s，一共就等了3s了。所以这里-passedTime
                    this.wait(timeout-passedTime);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                passedTime = System.currentTimeMillis()-begin;
            }
            return response;
        }
    }
    public void comlete(Object response){

        synchronized (this){
            this.response=response;
            this.notifyAll();
        }
    }
}