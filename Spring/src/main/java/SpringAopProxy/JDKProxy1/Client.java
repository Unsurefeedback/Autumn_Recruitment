package SpringAopProxy.JDKProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 14:35
 **/
public class Client {
    public static void main(String[] args) {
        //目标对象:程序员
        ISolver developer = new Solver();
        //代理：客服小姐姐
        ISolver csProxy = (ISolver) new ProxyFactory(developer).getProxyInstance();
        //目标方法：解决问题
        csProxy.solve();

        // 目标对象: 程序员
        final Solver developer1 = new Solver(); // 注意这里使用了 final，因为匿名内部类需要访问它

        // 直接使用 Proxy.newProxyInstance 创建代理
        ISolver csProxy1 = (ISolver) Proxy.newProxyInstance(
                Solver.class.getClassLoader(),
                Solver.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("请问有什么可以帮到您？");

                        // 调用目标对象方法
                        Object returnValue = method.invoke(developer1, args);

                        System.out.println("问题已经解决啦！");

                        // 返回方法调用的结果
                        return returnValue;
                    }
                }
        );
        csProxy1.solve();
    }
}
