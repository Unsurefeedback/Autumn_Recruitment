package SpringAopProxy.CglibProxy2;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 13:04
 **/
public class Client {
    public static void main(String[] args) {
        //目标对象:程序员
        Solver developer = new Solver();
        //代理：客服小姐姐
        Solver csProxy = (Solver) new ProxyFactory(developer).getProxyInstance();
        //目标方法：解决问题
        csProxy.solve();
    }
}
