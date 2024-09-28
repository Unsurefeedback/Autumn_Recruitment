package Volatile;

/**
 * @author WeiHanQiang
 * @date 2024/08/14 14:28
 **/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest2 {
    public int inc = 0;
    private final Lock lock = new ReentrantLock();

    public void increase() {
        inc++; // 进行递增操作

        /* lock.lock(); // 获取锁
        try {
            inc++; // 进行递增操作
        } finally {
            lock.unlock(); // 确保释放锁
        } */
    }

    public static void main(String[] args) {
        final VolatileTest2 test = new VolatileTest2();

        // 启动10个线程，每个线程执行1000次increase方法
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        test.increase();
                    }
                }
            }.start();
        }

        // 等待所有线程执行完毕
        while (Thread.activeCount() > 1) {
            Thread.yield(); // 让出当前线程的执行，以便其他线程可以运行
        }

        // 输出最终的inc值
        System.out.println("add lock, inc output: " + test.inc);
    }
}
