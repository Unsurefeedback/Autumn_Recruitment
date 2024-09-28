package SpringAopProxy.CglibProxy3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 13:22
 **/
public class CglibProxyExample {
    public static void main(String[] args) {
        BusinessService businessService = new BusinessService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BusinessService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("方法执行前......");
                Object result = methodProxy.invokeSuper(o,objects);
                System.out.println("方法执行后......");
                return result;
            }
        });
        BusinessService proxy = (BusinessService) enhancer.create();
        proxy.executeBusinessLogic();
    }
}
