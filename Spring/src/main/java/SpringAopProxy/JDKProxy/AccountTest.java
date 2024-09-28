package SpringAopProxy.JDKProxy;

import SpringAopProxy.CglibProxy.AccountCglibProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author WeiHanQiang
 * @date 2024/09/25 15:03
 **/
public class AccountTest {
    public static void main(String[] args) {
        Account account = new RealAccount("Allen");
        InvocationHandler handler = new AccountHandler(account);
        Account proxy = (Account) Proxy.newProxyInstance(
                account.getClass().getClassLoader(),
                account.getClass().getInterfaces(),
                handler);
        proxy.open();

        // AccountCglibProxy CglibProxy = new AccountCglibProxy();
        // RealAccount CglibAccount = (RealAccount) CglibProxy.getProxy(RealAccount.class);
        // account.open();
    }
}
