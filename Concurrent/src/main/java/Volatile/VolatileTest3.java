package Volatile;

/**
 * @author WeiHanQiang
 * @date 2024/08/31 09:11
 **/
public class VolatileTest3 {
    private int num = 0;
    /** private boolean flag = false; */
    /**
     * 不使用volatile修饰，会导致其它线程无法及时看到共享变量的修改
     */
    private volatile boolean flag = false;
    public void addNum(){
        num++;
    }
    public int getNum(){
        return num;
    }

    public static void main(String[] args) {
        VolatileTest3 t = new VolatileTest3();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                t.addNum();
                System.out.println("now addNum次数为"+i);
                try{
                    Thread.sleep(500L);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            t.flag = true;
            System.out.println("flag 设置为" + t.flag);
        }).start();
        new Thread(()->{
            while(!t.flag){

            }
            System.out.println("某个线程在t.flag为"+t.flag+"时获取数据 num: "+t.getNum());;
        }).start();
    }

}
