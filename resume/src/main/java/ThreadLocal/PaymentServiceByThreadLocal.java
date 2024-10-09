package ThreadLocal;

/**
 * @author WeiHanQiang
 * @date 2024/10/09 17:22
 **/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentServiceByThreadLocal {
    // 使用 ThreadLocal 存储用户上下文
    private static final ThreadLocal<String> userContext = new ThreadLocal<>();

    public void processPayment(String userId) {
        // 设置用户上下文信息
        userContext.set("User: " + userId);

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 提交支付处理任务
        executor.submit(() -> {
            // 模拟异步调用，处理支付请求
            handlePayment();
        });

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
        PaymentServiceByThreadLocal service = new PaymentServiceByThreadLocal();
        service.processPayment("12345");
    }
}

