package 其他算法.设计模式.单例;

import 代码随想录.二叉树.test;

public class Singleton  {
    public static volatile Singleton singleton;
    //静态标志位，用于防反射（全局唯一）
    private static volatile boolean isCreated = false;

    //真正的构造方法：必须是 private，且没有返回值类型！
    private Singleton() {
        synchronized (Singleton.class) {
            if (isCreated) {
                throw new RuntimeException("不允许反射创建单例！");
            }
            // 正常创建时，将标志位设为 true
            isCreated = true;
        }
    }

    // 4. 获取实例的方法
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}



