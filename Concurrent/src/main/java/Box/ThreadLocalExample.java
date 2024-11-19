package Box;

/**
 * @author WeiHanQiang
 * @date 2024/11/12 15:58
 **/
public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
    public static void main(String[] args) {
        Runnable task = ()->{
          int value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " initial value: "+ value);
            threadLocal.set(value + 1);
            System.out.println(Thread.currentThread().getName() + " updated value: "+ threadLocal.get());
        };

        Thread thread1 = new Thread(task," Thread 1");
        Thread thread2 = new Thread(task," Thread 2");
        thread1.start();
        thread2.start();
    }

}
