package 其他算法.其他.JUC.线程池;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class 线程池2 {
    public static void main(String[] args) {
        //策略模式
        ThreadPool threadPool = new ThreadPool(2, 1000, TimeUnit.MINUTES, 10,(blockQueue,task)->{
            blockQueue.put();//死等逻辑
        });
        for (int i = 0; i < 5; i++) {
            int j = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(j);
                }
            });
        }
    }
    static class ThreadPool {
        private BlockQueue<Runnable> blockQueue;
        private HashSet<Worker> workders = new HashSet<>();
        private int coreSize;
        //超时时间
        private long timeout;
        //单位
        private TimeUnit unit;
        //拒绝策略
        //最大线程数
        private RejectPolicy<Runnable> runnableRejectPolicy;
        public ThreadPool(int coreSize, long timeout, TimeUnit unit, int captity, RejectPolicy<Runnable> runnableRejectPolicy) {
            this.coreSize = coreSize;
            this.timeout = timeout;
            this.unit = unit;
            blockQueue = new BlockQueue<>(captity);
            this.runnableRejectPolicy = runnableRejectPolicy;
        }
        //肯定来一个启动方法
        private void execute(Runnable task) {
            synchronized (this) {
                if (workders.size() < coreSize) {
                    //创建线程
                    Worker worker = new Worker(task);
                    workders.add(worker);
                    worker.start();
                } else {//进入队列
                    blockQueue.tryPut(runnableRejectPolicy, task);
                    //blockQueue.add(task);
                }
            }
        }

        //Worker和线程不同的是，他会去阻塞队列拿线程自动消费
        class Worker extends Thread {
            private Runnable task;
            public Worker(Runnable task) {
                this.task = task;
            }
            @Override
            public void run() {
                while (task != null || (task = blockQueue.putTimed(timeout, unit)) != null) {
                    task.run();
                }
                //没有任务后应该等一会在销毁
                synchronized (workders) {//锁对象不是自己，不然锁没用，要用所有线程共享变量
                    workders.remove(this);
                }
            }
        }
    }
    static class BlockQueue<T> {
        private LinkedList<T> queue = new LinkedList<>();
        private final int captity;
        private final ReentrantLock lockC = new ReentrantLock();
        private final ReentrantLock lockX = new ReentrantLock();
        Condition CS = lockC.newCondition();
        Condition CX = lockX.newCondition();
        public BlockQueue(int captity) {
            this.captity = captity;
        }
        //生产者添加
        private void add(T task) {
            lockC.lock();
            try {
                while (queue.size() < captity) {
                    try {
                        CS.await();
                    } catch (InterruptedException e) {
                        System.out.println("生产者等待中被唤醒");
                    }
                }
                queue.addLast(task);
                CX.signalAll();
            } finally {
                lockC.unlock();
            }
        }
        //生产者限时添加
        private boolean offer(T task, long timeout, TimeUnit unit) {
            //lockC.tryLock();注意不是尝试获取锁，是获取锁后尝试添加
            lockC.lock();
            try {
                long nanos = unit.toNanos(timeout);
                while (queue.size() < captity) {
                    if (nanos < 0) {
                        return false;
                    }
                    try {
                        nanos = CS.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                        System.out.println("生产者等待中被唤醒");
                    }
                }
                queue.addLast(task);
                CX.signalAll();
                return true;
            } finally {
                lockC.unlock();
            }
        }
        //消费者拿取
        private T put() {
            lockX.lock();
            try {
                while (queue.isEmpty()) {
                    try {
                        CX.await();
                    } catch (InterruptedException e) {
                        System.out.println("消费者等待中被唤醒");
                    }
                }
                T task = queue.removeFirst();
                CS.signalAll();
                return task;
            } finally {
                lockX.unlock();
            }
        }
        //消费者时限拿取
        private T putTimed(long time, TimeUnit unit) {
            lockX.lock();
            try {
                long nanos = unit.toNanos(time);
                while (queue.isEmpty()) {
                    if (nanos < 0) {
                        return null;
                    }
                    try {
                        nanos = CX.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                        System.out.println("消费者等待中被唤醒");
                    }
                }
                T task = queue.removeFirst();
                CS.signalAll();
                return task;
            } finally {
                lockX.unlock();
            }
        }
        private synchronized int size() {
            return queue.size();
        }
        //带拒绝策略的添加
        public void tryPut(RejectPolicy<T> runnableRejectPolicy, T task) {
            lockC.lock();
            try {
                if(queue.size()==captity){
                    //执行拒绝策略
                    runnableRejectPolicy.reject(this,task);
                }else {
                    queue.addLast(task);
                    CX.signalAll();
                }
            } finally {
                lockC.unlock();
            }
        }
    }
    @FunctionalInterface
    interface RejectPolicy<T> {
        //不一定是Runnable，未来有可能是callable
        void reject(BlockQueue<T> tBlockQueue, T task);
    }
}



