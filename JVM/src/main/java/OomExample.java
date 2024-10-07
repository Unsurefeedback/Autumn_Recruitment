import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WeiHanQiang
 * @date 2024/09/30 11:32
 **/
public class OomExample {
    public static void main(String[] args) {
/*         Map<Integer,byte[]> map = new HashMap<>(10);
        int i = 0;

        while (true){
            byte[] bytes = new byte[1024*1024*100];
            i++;
            System.out.println(i);
            map.put(i,bytes);
        } */

        List<byte[]> bigObjects = new ArrayList<>();
        try{
            while(true){
                byte[] bigobject = new byte[10 * 1024 * 1024];
                bigObjects.add(bigobject);
            }
        }catch (OutOfMemoryError e){
            System.out.println("OutOfMemoryError 发生在" + bigObjects.size() +"对象后");
            throw e;
        }
    }
}
