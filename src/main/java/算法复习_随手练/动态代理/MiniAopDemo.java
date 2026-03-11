package 算法复习_随手练.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// ==========================================
// 1. 核心业务接口与实现 (AOP 术语：Target 目标对象)
// ==========================================
interface OrderService {
    String createOrder(String productId, int amount);
    void cancelOrder(String orderId);
}

class OrderServiceImpl implements OrderService {
    @Override
    public String createOrder(String productId, int amount) {
        System.out.println("    => [核心业务] 正在扣减库存，创建订单... 商品:" + productId + ", 数量:" + amount);
        return "ORDER_123456";
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("    => [核心业务] 订单 " + orderId + " 已取消，释放库存...");
    }
}

// ==========================================
// 2. 抽离切面逻辑 (AOP 术语：Advice 通知/增强)
// 我们定义一个接口，规定在方法执行前后要做什么
// ==========================================
interface Advice {
    void before(Method method, Object[] args);
    void afterReturning(Method method, Object result);
}

// 这是一个具体的“日志切面”实现
class LogAdvice implements Advice {
    @Override
    public void before(Method method, Object[] args) {
        System.out.println("\n[AOP 前置通知] 方法: " + method.getName() + " | 入参: " + Arrays.toString(args));
    }

    @Override
    public void afterReturning(Method method, Object result) {
        System.out.println("[AOP 后置通知] 方法: " + method.getName() + " | 返回值: " + result);
        System.out.println("--------------------------------------------------");
    }
}

// ==========================================
// 3. AOP 代理工厂 (AOP 术语：Weaver 织入器)
// 核心引擎：负责把 Target 和 Advice 缝合在一起
// ==========================================
class AopProxyFactory {
    // 这是一个通用的获取代理对象的方法
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(T target, Advice advice) {
        
        // 这里就使用了你刚才截图里注意到的【匿名内部类】写法！
        return (T) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // 1. 执行前置增强
                    advice.before(method, args);
                    
                    // 2. 执行核心业务 (利用内部包装的 target 对象)
                    Object result = method.invoke(target, args);
                    
                    // 3. 执行后置增强
                    advice.afterReturning(method, result);
                    
                    // 4. 返回结果
                    return result;
                }
            }
        );
    }

}

// ==========================================
// 4. 客户端测试 (模拟 Spring IoC 容器启动和调用)
// ==========================================
public class MiniAopDemo {
    public static void main(String[] args) {
        // 步骤 1：准备原始的 Bean (Target)
        OrderService targetBean = new OrderServiceImpl();
        
        // 步骤 2：准备切面逻辑 (Advice)
        Advice logAspect = new LogAdvice();
        
        // 步骤 3：模拟 Spring AOP 的 "狸猫换太子" (Weaving)
        // 容器启动时，发现该 Bean 需要被增强，于是通过工厂生成代理对象
        OrderService proxyBean = AopProxyFactory.getProxy(targetBean, logAspect);
        
        // 步骤 4：实际运行
        // 此时我们拿到的 proxyBean 已经是被增强过的代理对象了
        System.out.println("当前运行的 Bean 类型: " + proxyBean.getClass().getName());
        
        // 调用方法，完美触发 AOP 流程
        String orderId = proxyBean.createOrder("MacBook Pro", 1);
        proxyBean.cancelOrder(orderId);
    }

}
