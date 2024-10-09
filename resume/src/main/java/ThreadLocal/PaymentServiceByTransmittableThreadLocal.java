package ThreadLocal;

/**
 * @author WeiHanQiang
 * @date 2024/10/09 17:20
 **/
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentServiceByTransmittableThreadLocal {
    // 使用 TransmittableThreadLocal 存储用户上下文
    private static final TransmittableThreadLocal<String> userContext = new TransmittableThreadLocal<>();

    public void processPayment(String userId) {
        // 设置用户上下文信息
        userContext.set("User: " + userId);

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 提交支付处理任务
        executor.submit(TtlRunnable.get(() -> {
            // 模拟异步调用，处理支付请求
            handlePayment();
        }));

        executor.shutdown();
    }

    private void handlePayment() {
        // 在异步任务中获取用户上下文
        System.out.println(Thread.currentThread().getName() + " - Processing payment for: " + userContext.get());

        // 模拟进一步的异步处理
        handleConfirmation();
    }

    private void handleConfirmation() {
        // 继续传递上下文
        System.out.println(Thread.currentThread().getName() + " - Confirming payment for: " + userContext.get());
    }

    public static void main(String[] args) {
        PaymentServiceByTransmittableThreadLocal service = new PaymentServiceByTransmittableThreadLocal();
        service.processPayment("12345");
    }
}
