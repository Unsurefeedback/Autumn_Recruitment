package ThreadMethod;

import java.util.ArrayList;

/**
 * @author WeiHanQiang
 * @date 2024/10/13 10:52
 **/

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            for (int i = 0; i < 5000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("已经是停止状态了!我要退出了!");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("for函数之后");
        } catch (Exception e){
            System.out.println("进入 MyThread 的 catch 块");
            e.printStackTrace();
        }


    }
}

