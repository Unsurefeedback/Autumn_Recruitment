package CompletableFuture;

/**
 * @author WeiHanQiang
 * @date 2024/09/12 15:17
 **/
import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FutureExample {

    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 使用Guava的ListeningExecutorService来包装原始的ExecutorService
        ListeningExecutorService guavaExecutor = MoreExecutors.listeningDecorator(executor);

        // 提交任务并获取ListenableFuture
        ListenableFuture<String> future1 = guavaExecutor.submit(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        });

        ListenableFuture<String> future2 = guavaExecutor.submit(() -> {
            System.out.println("执行step 2");
            return "step2 result";
        });

        // 等待所有Future完成
        ListenableFuture<List<String>> future1And2 = Futures.allAsList(future1, future2);

        // 添加回调来处理future1And2的结果
        Futures.addCallback(future1And2, new FutureCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> result) {
                System.out.println(result);

                // 提交另一个任务
                ListenableFuture<String> future3 = guavaExecutor.submit(() -> {
                    System.out.println("执行step 3");
                    return "step3 result";
                });

                // 添加回调来处理future3的结果
                Futures.addCallback(future3, new FutureCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println(result);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                    }
                }, guavaExecutor);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        }, guavaExecutor);

        // 等待一段时间以确保所有任务完成（在实际应用中，你可能需要更复杂的逻辑来处理关闭）
        try {
            Thread.sleep(1000); // 等待足够的时间以确保所有任务都执行完毕
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 关闭ExecutorService
        executor.shutdown();
        try {
            // 等待ExecutorService中的所有任务完成
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // 超时后尝试停止所有正在执行的任务
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
