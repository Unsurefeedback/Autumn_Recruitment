package ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WeiHanQiang
 * @date 2024/10/09 17:06
 **/

public class ThreadLocalExample {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 主线程设置 ThreadLocal 变量
        threadLocal.set("Parent Thread Value");

        // 在线程池中执行任务
        executorService.submit(() -> {
            System.out.println("Child Thread Value: " + threadLocal.get());
        });

        // 关闭线程池
        executorService.shutdown();
    }
}

