package 其他算法.其他.设计模式.单例;

public class test {
    private static volatile test single=null;
    private static volatile boolean isHave=false;
    public test() {
        synchronized (this){
            if(isHave||single!=null){
                throw new RuntimeException();
            }
        }
        isHave=true;
    }
    public test get(){
        if(single==null){
            synchronized (this){
                if(single==null){
                    single=new test();
                }
            }
        }
        return single;
    }
}
