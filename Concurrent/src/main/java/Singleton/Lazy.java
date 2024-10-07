package Singleton;

/**
 * @author WeiHanQiang
 * @date 2024/09/29 20:53
 **/
public class Lazy {
    public static volatile Lazy instance;

    public static Lazy getInstance(){
        if(instance == null){
            synchronized (Lazy.class){
                if(instance == null){
                    instance =  new Lazy();
                }
            }
        }
        return instance;
    }

}
