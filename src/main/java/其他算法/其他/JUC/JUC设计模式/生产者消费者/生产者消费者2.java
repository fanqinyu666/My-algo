package 其他算法.其他.JUC.JUC设计模式.生产者消费者;

import java.util.LinkedList;

//生产者消费者，写的就是个队列，队列写完了其他俩随便写的
public class 生产者消费者2 {
    public static void main(String[] args) {
        BufferQueue bufferQueue = new BufferQueue(3);
        for (int i = 0; i < 5; i++) {
            int a=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bufferQueue.add(a);
                }
            },"生产者"+i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bufferQueue.put();
                }
            },"消费者"+i).start();
        }

    }
}

//java线程间通信的一个类
class BufferQueue{
    private LinkedList<Integer> queue=new LinkedList<>();//我们传输的类型应该是自定义类，内部必须有id（这里用int代替，当id）
    //目前大小,这东西没必要啊，你双向链表都有了
    //private int size=0;
    //容量

    private int captity;
    public BufferQueue(int captity) {
        this.captity = captity;
    }


    //添加消息的方法
    public synchronized void add(int ss){
        while(queue.size()>=captity){
            try {
                System.out.println("队列满了，生产者等待");
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("被唤醒");
            }
        }
        System.out.println("生产消息"+ss);
        queue.addFirst(ss);
        notifyAll();
    }
    //获取消息方法
    public synchronized Integer put(){
        //检查队列是否为空，卧槽！！老子又忘记虚假唤醒问题了
        //if(size==0){
        while(queue.size()==0){
            try {
                System.out.println("队列空了，消费者等待");
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("被唤醒");
            }
        }
        Integer remove = queue.removeLast();
        System.out.println("消费消息"+remove);
        notifyAll();
        return remove;
    }
}//你线程数量少可以用cas自旋优化，线程多可以把锁粒度减小，两端各自整一个锁