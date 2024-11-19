import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

/**
 * @author WeiHanQiang
 * @date 2024/08/14 11:25
 **/
public class Test1 {
    @Test
    public void test() throws Exception {
        //单一线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //InheritableThreadLocal存储
        InheritableThreadLocal<String> username = new InheritableThreadLocal<>();
        for (int i = 0; i < 10; i++) {
            username.set("公众号：码猿技术专栏—"+i);
            Thread.sleep(1000);
            CompletableFuture.runAsync(()-> System.out.println(username.get()),executorService);
        }
    }

    @Test
    public void test1() throws Exception {
        //单一线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //需要使用TtlExecutors对线程池包装一下
        executorService= TtlExecutors.getTtlExecutorService(executorService);
        //TransmittableThreadLocal创建
        TransmittableThreadLocal<String> username = new TransmittableThreadLocal<>();
        for (int i = 0; i < 10; i++) {
            username.set("公众号：码猿技术专栏—"+i);
            Thread.sleep(1000);
            CompletableFuture.runAsync(()-> System.out.println(username.get()),executorService);
        }
    }

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
