package SpringAopProxy.JDKProxy;

import SpringAopProxy.JDKProxy.Account;

/**
 * @author WeiHanQiang
 * @date 2024/09/25 15:01
 **/
class RealAccount implements Account {
    private String name;
    public RealAccount(String name) {
        this.name = name;
    }
    @Override
    public void open() {
        System.out.println("Open the account for:" + name);
    }
}
