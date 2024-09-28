package Runnable;

/**
 * @author WeiHanQiang
 * @date 2024/08/14 11:09
 **/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolWithRunnableExample {
    public static void main(String[] args) {
        // 创建一个包含5个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 创建一个Runnable任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };

        // 提交任务到ExecutorService执行
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }

        // 关闭ExecutorService，不再接受新的任务，等待所有已提交的任务完成
        executorService.shutdown();

        try {
            // 可选：等待所有任务完成
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                // 如果超时，则尝试立即关闭线程池
                System.out.println("ExecutorService did not terminate in the given time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            // 如果当前线程被中断，则取消尚未执行的任务，并立即关闭线程池
            System.out.println("Current thread was interrupted, shutting down immediately.");
            executorService.shutdownNow();
            Thread.currentThread().interrupt(); // 重新设置中断状态
        }
    }
}
