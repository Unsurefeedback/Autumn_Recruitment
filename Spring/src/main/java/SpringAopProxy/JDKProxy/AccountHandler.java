package SpringAopProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author WeiHanQiang
 * @date 2024/09/25 15:02
 **/
public class AccountHandler implements InvocationHandler {
    private Object obj;
    public AccountHandler(Object obj) {
        super();
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] arg)
            throws Throwable {
        Object result = null;
        doBefore();
        result = method.invoke(obj, arg);
        doAfter();
        return result;
    }
    public void doBefore() {
        System.out.println("开户前");
    }
    public void doAfter() {
        System.out.println("开户后");
    }
}
