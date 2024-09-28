package Runnable;

/**
 * @author WeiHanQiang
 * @date 2024/08/14 10:38
 **/
public class RunnableTest1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try{
                Thread.sleep(20);
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "吃了：" + i + "棵树");
        }
    }

    public static void main(String[] args) {
        RunnableTest1 runnableTest1 = new RunnableTest1();
        Thread t1 = new Thread(runnableTest1,"云");
        Thread t2 = new Thread(runnableTest1,"海");
        Thread t3 = new Thread(runnableTest1,"天");

        t1.start();
        t2.start();
        t3.start();
    }
}
