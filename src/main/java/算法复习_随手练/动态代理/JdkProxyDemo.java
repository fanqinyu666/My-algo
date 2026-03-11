package 算法复习_随手练.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// ==========================================
// 1. 定义接口（JDK 动态代理的硬性要求：必须有接口）
// ==========================================
interface UserService {
    void login(String username);
    void logout();
}

// ==========================================
// 2. 目标对象（Target）：真正干活的原生类
// ==========================================
class UserServiceImpl implements UserService {
    @Override
    public void login(String username) {
        System.out.println("    => [核心业务] 数据库校验中... 欢迎用户：[" + username + "] 登录成功！");
    }

    @Override
    public void logout() {
        System.out.println("    => [核心业务] 清理 Session... 用户已安全登出！");
    }
}

// ==========================================
// 3. 核心拦截器：实现 InvocationHandler
// ==========================================
class LogInvocationHandler implements InvocationHandler {
    
    // 【第一层套娃】：内部必须持有目标对象
    private final Object target;

    // 通过构造方法把目标对象传进来
    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // --- AOP 前置增强 ---
        System.out.println("[AOP 拦截] 方法 <" + method.getName() + "> 准备执行。开启事务/记录日志...");

        // --- 核心调用（反射） ---
        // 这里就是用保存好的 target，去真正执行对应的方法
        Object result = method.invoke(target, args);

        // --- AOP 后置增强 ---
        System.out.println("[AOP 拦截] 方法 <" + method.getName() + "> 执行完毕。提交事务/耗时统计...\n");

        return result;
    }
}
// ==========================================
// 4. 客户端测试类（模拟 Spring IoC 容器的行为）
// ==========================================
public class JdkProxyDemo {
    public static void main(String[] args) {
        
        // 步骤 1：实例化原生目标对象（也就是你截图里第一步 Spring 创建的 Bean）
        UserService target = new UserServiceImpl();

        // 步骤 2：实例化 Handler，并把目标对象包进去
        InvocationHandler handler = new LogInvocationHandler(target);

        // 步骤 3：【第二层套娃】呼叫 JDK 生成代理对象！
        // 这就是你截图里第 9 步“狸猫换太子”的底层动作
        UserService proxy = (UserService) Proxy.newProxyInstance(
            target.getClass().getClassLoader(), // 参数1：目标对象的类加载器
            target.getClass().getInterfaces(),  // 参数2：目标对象实现了哪些接口（代理类也要实现这些接口）
            handler                             // 参数3：你写好的拦截逻辑
        );

        // 步骤 4：测试运行
        System.out.println("--- 测试开始 ---");
        System.out.println("代理对象的真实类型是: " + proxy.getClass().getName() + "\n");
        
        // 当你调用代理对象的方法时，它会自动走 handler.invoke()
        proxy.login("张三");
        proxy.logout();
    }
}