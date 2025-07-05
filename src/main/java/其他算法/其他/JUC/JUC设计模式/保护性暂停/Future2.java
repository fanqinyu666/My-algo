package 其他算法.其他.JUC.JUC设计模式.保护性暂停;

public class Future2 {


}
class GuardedObject2 {
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
class GuardedObject3 {
    private Object response;

    public Object get(long timeout){

        synchronized (this){
            long now = System.currentTimeMillis();
            long fin=0;
            while (response==null){
                if(fin>=timeout)break;
                try {
                    this.wait(timeout-fin);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                fin=System.currentTimeMillis()-now;
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