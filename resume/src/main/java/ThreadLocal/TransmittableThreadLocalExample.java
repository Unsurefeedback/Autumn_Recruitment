package ThreadLocal;

/**
 * @author WeiHanQiang
 * @date 2024/10/09 17:07
 **/
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalExample {
    private static TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 主线程设置 TransmittableThreadLocal 变量
        transmittableThreadLocal.set("Parent Thread Value");

        // 在线程池中执行任务
        executorService.submit(TtlRunnable.get(() -> {
            System.out.println("Child Thread Value: " + transmittableThreadLocal.get());
        }));

        // 关闭线程池
        executorService.shutdown();
    }
}
