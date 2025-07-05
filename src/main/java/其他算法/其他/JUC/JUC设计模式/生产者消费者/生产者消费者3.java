package 其他算法.其他.JUC.JUC设计模式.生产者消费者;

import java.util.LinkedList;

public class 生产者消费者3 {


}

class BufferQueue3{

    private LinkedList<Integer> queue=new LinkedList<>();
    private int captity;

    public BufferQueue3(int captity) {
        this.captity = captity;
    }

    public synchronized Integer get(){
        while(queue.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Integer i = queue.removeFirst();
        this.notifyAll();
        return i;
    }
    public synchronized void put(int i){
        while(queue.size()==captity){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.addLast(i);
        this.notifyAll();
    }


}
