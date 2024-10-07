package Singleton;

/**
 * @author WeiHanQiang
 * @date 2024/09/29 20:51
 **/
public class Hungry {
    private static final Hungry hungry = new Hungry();

    private Hungry() {

    }
    public static Hungry getInstance(){
        return hungry;
    }
}
