package Box;

/**
 * @author WeiHanQiang
 * @date 2024/11/19 16:42
 **/
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        // 示例数据
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Alice");

        // 1. 过滤 (Filter) - 找出以"A"开头的名字
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("以'A'开头的名字: " + filteredNames);

        // 2. 映射 (Map) - 将名字转换为大写
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("大写名字: " + upperCaseNames);

        // 3. 去重 (Distinct) - 去除重复的名字
        List<String> distinctNames = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("去重后的名字: " + distinctNames);

        // 4. 排序 (Sorted) - 按字典顺序排序
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("排序后的名字: " + sortedNames);

        // 5. 统计 (Count) - 统计名字数量
        long count = names.stream()
                .filter(name -> name.length() > 3)
                .count();
        System.out.println("长度大于3的名字数量: " + count);

        // 6. 收集 (Collect) - 将名字拼接成字符串
        String joinedNames = names.stream()
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("拼接后的名字: " + joinedNames);

        // 7. 生成 (Generate) - 生成无限流 (需加限制)
        List<Double> randomNumbers = Stream.generate(Math::random)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("随机数: " + randomNumbers);

        // 8. 归约 (Reduce) - 计算名字的总长度
        int totalLength = names.stream()
                .map(String::length)
                .reduce(0, Integer::sum);
        System.out.println("名字总长度: " + totalLength);
    }
}

