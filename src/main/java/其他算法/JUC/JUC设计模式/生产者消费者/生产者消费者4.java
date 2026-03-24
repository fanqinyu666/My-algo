package 其他算法.JUC.JUC设计模式.生产者消费者;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 生产者消费者4 {




}
class MessageQueue{

    private LinkedList<Integer> queue=new LinkedList<>();
    private int captity;

    private final static ReentrantLock lockS=new ReentrantLock();
    private final static ReentrantLock lockX=new ReentrantLock();
    Condition CS=lockS.newCondition();
    Condition CX=lockX.newCondition();


    public MessageQueue(int captity) {
        this.captity = captity;
    }

    public void add(int num){
        lockS.lock();
        try {
            while (queue.size() >= captity)CS.wait();
            queue.add(num);
            CX.notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lockS.unlock();
        }
    }


    //获取消息方法
    public Integer tack(){
        lockX.lock();
        try {
            while(queue.isEmpty())CX.wait();
            Integer remove = queue.removeLast();
            CS.notifyAll();
            return remove;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lockX.unlock();
        }

    }



}

