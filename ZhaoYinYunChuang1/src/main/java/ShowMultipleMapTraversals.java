import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author WeiHanQiang
 * @date 2024/09/24 14:22
 **/
public class ShowMultipleMapTraversals {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>(10);
        map.put("Apple",1);
        map.put("Sea",1);
        map.put("Forest",1);

        // 遍历 entrySet
        System.out.println("使用 Map.Entry<String,Integer> set : map.entrySet() 方法遍历");
        for(Map.Entry<String,Integer> set : map.entrySet()){
            System.out.println("Key: "+set.getKey()+" Value: "+set.getValue());
        }
        System.out.println("————————————————————");


        // 遍历 keySet
        System.out.println("使用 String key : map.keySet() 的方式遍历");
        for(String key : map.keySet()){
            System.out.println("Key: " + key + " Value: "+ map.get(key));
        }
        System.out.println("————————————————————");


        // 遍历 values
        System.out.println("使用 Integer value : map.values() 的方式遍历");
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        System.out.println("————————————————————");


        // 使用 forEach
        System.out.println("使用 forEach 的方式遍历");
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("————————————————————");


        // 使用迭代器遍历 entrySet
        System.out.println("使用 forEach 的方式遍历");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
