package ThreadMethod;

/**
 * @author WeiHanQiang
 * @date 2024/10/13 10:40
 **/
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread.currentThread().getName(): "+ Thread.currentThread().getName());
                Thread.currentThread().getName();
                System.out.println("子线程被调用!");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5);
        myThread.interrupt();
    }

}


