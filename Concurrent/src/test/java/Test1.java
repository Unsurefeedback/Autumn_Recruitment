import org.junit.Test;

/**
 * @author WeiHanQiang
 * @date 2024/08/14 11:25
 **/
public class Test1 {
    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        // Thread.sleep(1999L); // 需要注意这里main线程休眠了1000毫秒，而testMethod()里休眠了2000毫秒
        // a.join(1800L);
        b.start();

        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
