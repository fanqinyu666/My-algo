package 其他算法.其他.设计模式.单例;

import java.io.Serializable;

public final class Singleton2  {

    private static volatile Singleton2 instance;


    // 内部令牌类 - 确保只有我们自己能创建有效token
    private static final class SingletonToken {
        private SingletonToken() {} // 防止外部实例化
    }

    // 唯一有效的令牌实例
    private static final SingletonToken VALID_TOKEN = new SingletonToken();

    private Singleton2(SingletonToken token) {
        // 验证令牌的有效性
        if (token != VALID_TOKEN) {
            throw new IllegalArgumentException("Invalid token - reflection attack detected");
        }
        // 防止通过正常方式多次实例化
        if (instance != null) {
            throw new IllegalStateException("Singleton already instantiated");
        }
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    // 使用有效令牌创建实例
                    instance = new Singleton2(VALID_TOKEN);
                }
            }
        }
        return instance;
    }


    private Object readResolve(){
        return getInstance();
    }

}