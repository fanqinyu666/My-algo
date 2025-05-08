package 其他算法.其他.其他;

//单例模式
public class Singleton {
    private static volatile Singleton singleton = null;

    //将构造方法定义为私有的，不允许反射
    private Singleton() {

        //singleton已经实例化了，就抛出异常，因为实例化后不应该走这个流程，如果走了一定是用反射了
        if (singleton!= null) {
            throw new RuntimeException("Use getInstance() to get the singleton instance");
        }
    }

    public static Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }


}
