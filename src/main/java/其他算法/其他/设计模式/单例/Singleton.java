package 其他算法.其他.设计模式.单例;

public class Singleton  {

    private static volatile Singleton instance;
    //是否被初始化，
    private static volatile boolean initialized = false;

    public Singleton(){
        synchronized (Singleton.class){
            if(initialized||instance != null){
                throw new RuntimeException("禁止反射破坏单例");
            }
            initialized=true;
        }

    }

    //双重检查锁获得实例
    public static Singleton getInstance() {
        if(instance==null) {
            synchronized (Singleton.class){
                if(instance==null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
