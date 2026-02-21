package 算法复习_随手练.小练习;

public class singto {
    public static final Object lock=new Object();
    public static volatile singto singto;
    public volatile boolean isok=false;
    public singto() {
        synchronized (lock){
            if(isok&&singto==null)singto=new singto();
        }
        new Exception();
    }

    public static singto getSingto() {
        if(singto==null){
            synchronized (lock){
                if(singto==null)return new singto();
            }
        }
        return singto;
    }

}
