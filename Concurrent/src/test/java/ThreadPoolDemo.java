import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 创建一个固定大小的线程池，包含 5 个线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 提交 10 个任务到线程池
        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskNumber + " is running on thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskNumber + " is completed");
            });
        }

        // 关闭线程池，停止接收新任务
        executorService.shutdown();

        try {
            // 等待所有任务完成
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Some tasks were not completed within the timeout.");
                executorService.shutdownNow();
            } else {
                System.out.println("All tasks are completed.");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
