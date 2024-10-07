package String;

/**
 * @author WeiHanQiang
 * @date 2024/09/29 15:38
 **/
import java.util.Arrays;

public class ArrayCopyExample {
    public static void main(String[] args) {
        // 原始数组
        int[] originalArray = {1, 2, 3};

        // 打印原始数组
        System.out.println("Original array: " + Arrays.toString(originalArray));
        Integer i = Integer.parseInt("haha");
        System.out.println("i: " + i);
        // 使用 Arrays.copyOf 复制原始数组，并扩展到新的大小
        int[] copiedArray = Arrays.copyOf(originalArray, 5);

        // 打印复制后的新数组
        System.out.println("Copied array with extended size: " + Arrays.toString(copiedArray));

        // 可以看到，新的数组保留了原始数组的内容，并且后面增加了两个默认值（对于int类型，默认值为0）
    }
}
