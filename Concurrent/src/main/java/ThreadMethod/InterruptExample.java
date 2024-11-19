package ThreadMethod;

/**
 * @author WeiHanQiang
 * @date 2024/10/13 10:56
 **/
public class InterruptExample implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {  // 检查中断标志
            try {
                System.out.println("线程正在运行...");
                Thread.sleep(1000);  // 如果线程被中断，此时会抛出 InterruptedException
            } catch (InterruptedException e) {
                System.out.println("线程被中断！");
                Thread.currentThread().interrupt();  // 再次设置中断标志
                break;
            }
        }
        System.out.println("线程停止运行");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptExample());
        thread.start();
        Thread.sleep(3000);  // 主线程等待3秒
        thread.interrupt();  // 中断子线程
    }
}


