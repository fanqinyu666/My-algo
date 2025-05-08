package 其他算法.其他.JUC.ReenTrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenLock {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {


//多条件变量学习
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        lock.lock();
        //得到锁后才能等待（进入wait休息室）
        condition1.await();//wait方法会释放锁
        //别的线程调用这个方法，叫醒休息室里某一个线程
        condition1.signal();
        //全部叫醒
        condition1.signalAll();


        /*
        //公平锁
        ReentrantLock reentrantLock = new ReentrantLock(true);
*/
/*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b = false;
                try {
                    b = lock.tryLock(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!b){
                    System.out.println("获取不到");
                    return;
                }
                try {
                    System.out.println("获取成功");
                } finally {
                    lock.unlock();
                }

            }
        });
        lock.lock();
        thread.start();

*/


        //可打断
        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //线程没有竞争就会获取锁
                    //线程有竞争就进入阻塞队列，但是可以被其他线程打断阻塞
                    System.out.println("尝试获取锁");
                    //我们打断的既然是阻塞的线程，肯定有异常抛出
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("打断了一个阻塞的线程");
                    throw new RuntimeException(e);
                }

                try {

                    System.out.println("获取到锁了");
                } finally {
                    lock.unlock();
                }


            }
        }, "t1");

        lock.lock();
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

*/
/*
//可重入
        lock.lock();
        try {
            System.out.println("1");
            m1();
        }finally {
            lock.unlock();
        }

 */
    }
    public static void m1() {
        lock.lock();
        try {
            System.out.println("2");
            m2();
        }finally {
            lock.unlock();
        }
    }
    public static void m2() {
        lock.lock();
        try {
            System.out.println("3");
        }finally {
            lock.unlock();
        }
    }



}
