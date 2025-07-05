package 其他算法.其他.设计模式.单例;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * 强化版双重检查锁单例模式
 * 特性：
 * 1. 线程安全初始化
 * 2. 防御反射攻击
 * 3. 防御序列化/反序列化破坏
 * 4. 防御克隆破坏
 */
public class UltimateSingleton implements Serializable, Cloneable {

    // volatile保证可见性，防止指令重排序
    private static volatile UltimateSingleton instance;

    // 状态标志位（防御反射修改访问权限后的多次实例化）
    private static volatile boolean initialized = false;

    /**
     * 私有化构造方法（防御反射的核心）
     */
    private UltimateSingleton() {
        synchronized (UltimateSingleton.class) {
            // 防御场景1：通过反射调用构造方法创建新实例
            // 防御场景2：多线程环境下反射攻击的竞态条件
            if (initialized || instance != null) {
                throw new IllegalStateException("禁止通过反射创建单例实例");
            }
            initialized = true;
        }
        // 真实的初始化逻辑可以放在这里
    }

    /**
     * 双重检查锁获取实例
     */
    public static UltimateSingleton getInstance() {
        if (instance == null) {
            synchronized (UltimateSingleton.class) {
                if (instance == null) {
                    instance = new UltimateSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 防御反序列化攻击（保证反序列化返回同一个实例）
     */
    private Object readResolve() {
        return getInstance();
    }

    /**
     * 防御克隆攻击
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("禁止克隆单例对象");
    }

    // ================== 测试代码 ==================
    public static void main(String[] args) {
        try {
            // 正常获取实例
            UltimateSingleton s1 = UltimateSingleton.getInstance();
            System.out.println("正常实例哈希值: " + s1.hashCode());

            // 测试反射攻击
            Constructor<UltimateSingleton> constructor = 
                UltimateSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            UltimateSingleton s2 = constructor.newInstance();
            System.out.println("反射实例哈希值: " + s2.hashCode());
        } catch (Exception e) {
            System.out.println("反射攻击防御结果:");
            e.printStackTrace();
        }

        // 测试多线程安全（可通过JUC压力测试工具验证）
        new Thread(() -> {
            UltimateSingleton s = UltimateSingleton.getInstance();
            System.out.println("线程1实例哈希值: " + s.hashCode());
        }).start();

        new Thread(() -> {
            UltimateSingleton s = UltimateSingleton.getInstance();
            System.out.println("线程2实例哈希值: " + s.hashCode());
        }).start();
    }
}