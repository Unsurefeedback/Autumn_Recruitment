package LRUCache;

/**
 * @author WeiHanQiang
 * @date 2024/09/30 13:30
 **/

/**
 * LRUCache 实现了一个简单的最近最少使用 (LRU) 缓存机制。
 * 当缓存超过设定的容量时，最久未使用的条目将被移除。
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // 构造函数，设置缓存的最大容量
    public LRUCache(int capacity) {
        // accessOrder = true 表示按访问顺序排序
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // 当缓存大小超过设定的容量时，移除最老的条目
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        // 创建一个容量为 5 的 LRU 缓存
        LRUCache<String, Double> lruCache = new LRUCache<String, Double>(5);

        // 插入示例数据
        for (int i = 1; i <= 8; i++) {
            String key = "User" + i;
            double value = Math.random();
            lruCache.put(key, value);
            System.out.println("Inserted: " + key + " with value: " + value);
        }

        // 访问某些条目，模拟使用，展示 LRU 的工作原理
        System.out.println("\nAccessing some entries:");
        for (int i = 3; i <= 5; i++) {
            System.out.println("Accessed: " + lruCache.get("User" + i));
        }

        // 打印当前缓存的状态
        System.out.println("\nCurrent Cache Contents (after accesses):");
        lruCache.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

