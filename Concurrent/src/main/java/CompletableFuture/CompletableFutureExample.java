package CompletableFuture;

/**
 * @author WeiHanQiang
 * @date 2024/09/12 15:23
 **/
import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        }, executor);

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 2");
            return "step2 result";
        }, executor); // 指定相同的executor

        cf1.thenCombine(cf2, (result1, result2) -> {
            System.out.println(result1 + " , " + result2);
            System.out.println("执行step 3");
            return "step3 result";
        })
        .thenAccept(result3 -> System.out.println(result3))
        .exceptionally(ex -> {
            System.err.println("发生异常: " + ex.getMessage());
            return null; // 或者返回默认值，根据需求决定
        });

        // 关闭ExecutorService，注意在实际应用中，你可能需要等待所有任务完成后再关闭
        // 这里只是演示，所以直接关闭了
        executor.shutdown();
    }
}