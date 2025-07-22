package 其他算法.其他.JUC.线程池;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class 线程池 {
    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPool(2,1000,TimeUnit.MINUTES,10);
        for (int i = 0; i <5; i++) {
            int j=i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            });
        }
    }

static class ThreadPool{
    //七大参数肯定要有
    private BufferQueue<Runnable> taskQueue;
    private HashSet<Workers> workers=new HashSet<>();
    //核心线程数
    private int coreSize;
    //超时时间
    private long timeout;
    //单位
    private TimeUnit unit;
    //拒绝策略
    //最大线程数
    public ThreadPool(int coreSize, long timeout, TimeUnit unit,int queueSize) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.unit = unit;
        taskQueue=new BufferQueue<>(queueSize);
    }

    //提交任务方法，传入一个Run
    private void execute(Runnable task){
        synchronized (this) {
            //如果核心线程数量比你任务中的多，那就创建新线程,并直接启动
            if (coreSize > workers.size()) {
                Workers worker = new Workers(task);//worker是共享资源，这三部需要原子性
                workers.add(worker);//添加进一个
                worker.start();
            } else {
                //否则就进入队列等待
                taskQueue.add(task);
            }
        }
    }

    //注意这个核心线程需要一直存在，不能完成一个任务后销毁，需要循环
    class Workers extends Thread{
        private Runnable task;
        public Workers(Runnable task) {
            this.task=task;
        }

        @Override
        public void run() {
            //执行任务
            //1.task不为空，执行
            //2.执行完成后去任务队列获取任务
            //while (task!=null||taskQueue.size()>0){,我这个判断太啰嗦了
            while (task!=null||(task=taskQueue.put())!=null){//直接队列里拿
                try {
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    task=null;
                }
            }

            synchronized (workers) {
                //到这里意思是没有队列无任务，手头也无任务，所以线程可以死了,直接去了当前this对象
                //但是核心线程外面不用让他死
                workers.remove(this);
            }

        }
    }
}

static class BufferQueue<T>{
        //1.队列
        private LinkedList<T> queue=new LinkedList<>();
        //2.容量容量
        private int captity;
        //3.生产者锁
        private final static ReentrantLock lockS=new ReentrantLock();
        //4.生产者条件变量
        Condition CS=lockS.newCondition();
        //4.消费者锁
        private final static ReentrantLock lockX=new ReentrantLock();
        //6.消费者条件变量
        Condition CX=lockX.newCondition();
        public BufferQueue(int captity) {
            this.captity = captity;
        }

        //添加一个任务
        public void add(T message){
            lockS.lock();
            try {
                while (queue.size()>=captity){
                    try {
                        CS.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.addFirst(message);
                CX.signalAll();
            } finally {
                lockS.unlock();
            }
        }


        //获取消息方法
        public T put(){
            lockX.lock();
            try {
                while (queue.size()==0){
                    try {
                        CX.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                T res = queue.removeLast();
                CS.signalAll();
                return res;
            } finally {
                lockX.unlock();
            }
        }

        //带超时时间的获取消息方法
        public T putTimed(long timeout, TimeUnit unit){
            lockX.lock();
            try {
                long nanos = unit.toNanos(timeout);//比其他时间单位转化为纳秒
                while (queue.size()==0){
                    try {
                        if(nanos<=0){
                            //超时直接return
                            return null;
                        }
                        nanos=CX.awaitNanos(nanos);//之前我们说过如果虚假唤醒，下次来还会等同样的时间，其实它底层就封装了System.currentTimeMillis()方法
                                            //底层给我们做了运算，返回的数据是等待后还剩余的时间
                                            //这样我们直接复制给nacos就好了
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                T res = queue.removeLast();
                CS.signalAll();
                return res;

            } finally {
                lockX.unlock();
            }
        }
        //这里要对获取容量获取加锁是我一开始没想到的
        public synchronized int size(){
            return queue.size();
        }
    }
}
