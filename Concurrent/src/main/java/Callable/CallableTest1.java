package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author WeiHanQiang
 * @date 2024/08/14 10:09
 **/
public class CallableTest1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello 啊";
    }

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<String>(new CallableTest1());
        Callable<String> call1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "试一试不写类，直接new出callable";
            }
        };
        FutureTask<String> task2 = new FutureTask<>(call1);
        new Thread(task2).start();
        new Thread(task).start();
        try{
            String res = task.get();
            System.out.println(res);

            String res2 = task2.get();
            System.out.println("task2:" + res2);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
