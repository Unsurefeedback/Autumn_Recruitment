package Callable;

import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个包含5个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 创建一个Callable任务
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // 模拟任务执行时间
                Thread.sleep(1000);
                return "Hello from " + Thread.currentThread().getName();
            }
        };

        // 提交任务到ExecutorService执行，并获取Future对象
        Future<String>[] futures = new Future[10];
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(task);
        }

        // 通过Future对象获取任务的结果，并处理可能的异常
        for (int i = 0; i < 10; i++) {
            try {
                // get方法会阻塞直到任务完成
                System.out.println(futures[i].get());
            } catch (InterruptedException e) {
                // 当前线程被中断时抛出此异常
                Thread.currentThread().interrupt(); // 重新设置中断状态
                System.out.println("任务执行被中断: " + e.getMessage());
            } catch (ExecutionException e) {
                // 任务执行过程中抛出的异常将被封装在ExecutionException中
                System.out.println("任务执行异常: " + e.getMessage());
            }
        }

        // 关闭ExecutorService，不再接受新的任务，等待所有已提交的任务完成
        executorService.shutdown();

        try {
            // 等待所有任务完成最多60秒
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                // 如果超时，则尝试立即关闭线程池
                System.out.println("超时，尝试立即关闭线程池");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            // 如果当前线程被中断，则立即关闭线程池
            System.out.println("关闭线程池时被中断: " + e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt(); // 重新设置中断状态
        }
    }
}