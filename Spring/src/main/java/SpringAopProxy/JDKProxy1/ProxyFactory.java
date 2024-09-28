package SpringAopProxy.JDKProxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 14:34
 **/
public class ProxyFactory {

    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("请问有什么可以帮到您？");

                        // 调用目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("问题已经解决啦！");
                        return null;
                    }
                });
    }
}
