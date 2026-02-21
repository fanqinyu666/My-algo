package 其他算法.设计模式.单例;

import 代码随想录.二叉树.test;

public class Singleton3 {
    //防止反射破坏单例
    private static volatile boolean isok=false;

    //避免有序性问题，和可见性
    private static volatile test test;

    private Singleton3() {
        synchronized (this){
            if(test!=null||isok){
                throw new RuntimeException("不允许反射创造");
            }
        }
        isok=true;
    }
    //双重检查锁
    public test getTest(){
        if(test==null){
            synchronized (this){
                if(test==null){
                    test=new test();
                }
            }
        }
        return test;
    }
}
