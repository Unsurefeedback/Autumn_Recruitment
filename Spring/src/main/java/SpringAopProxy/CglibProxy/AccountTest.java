package SpringAopProxy.CglibProxy;

import SpringAopProxy.JDKProxy.AccountHandler;
import SpringAopProxy.CglibProxy.RealAccount;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author WeiHanQiang
 * @date 2024/09/25 15:03
 **/
public class AccountTest {
    public static void main(String[] args) {
        AccountCglibProxy CglibProxy = new AccountCglibProxy();
        RealAccount CglibAccount = (RealAccount) CglibProxy.getProxy(RealAccount.class);
        CglibAccount.open();
    }
}
