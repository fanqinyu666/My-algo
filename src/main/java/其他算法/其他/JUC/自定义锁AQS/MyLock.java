package 其他算法.其他.JUC.自定义锁AQS;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    //不可重入的独占锁
    class MySycn extends AbstractQueuedSynchronizer{
        @Override//尝试获取所
        protected boolean tryAcquire(int arg) {//这个参数没用，因为他是不可重入锁
            if(compareAndSetState(0,1));{
                //加上锁了
                setExclusiveOwnerThread(Thread.currentThread());
            }
            return false;
        }
        @Override//尝试释放锁
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);//这里俩顺序有细节的
            setState(0);//state是voltile修饰的，写在后面，会有个读屏障不会进行指令重排序。
            //在他之前的指令重排序不会到这行后面，并且在他之前的对其他线程可见性保证
            return true;
        }
        @Override//是否持有独占锁
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
        //返回一个条件变量，这个我们自定义的
        protected Condition newCondition(){
            return new ConditionObject();//这个类是AQS内部类
        }
    }
    private MySycn sycn=new MySycn();


    @Override//加锁
    public void lock() {
        sycn.tryAcquire(1);//这个变量不是可重入锁没用
    }

    @Override//加可打断锁
    public void lockInterruptibly() throws InterruptedException {
        sycn.acquireInterruptibly(1);
    }

    @Override//尝试获取锁
    public boolean tryLock() {
         return sycn.tryAcquire(1);
    }

    @Override//带超时获取锁
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sycn.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override//解锁
    public void unlock() {
        //实际上的release内部调用了我们刚刚重写的方法tryRelease，还会唤醒阻塞线程，我们不会唤醒
        sycn.release(1);
    }

    @Override//创建条件变量
    public Condition newCondition() {
        return sycn.newCondition();
    }




}
