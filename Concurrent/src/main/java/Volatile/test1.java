package Volatile;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();  // 输入的字符串

        // 键盘行的布局
        String row1 = "QWERTYUIOP";
        String row2 = "ASDFGHJKL";
        String row3 = "ZXCVBNM";

        // 创建一个映射表
        Map<Character, Character> map = new HashMap<>();

        // 为每一行添加映射，反转字符位置
        addMapping(map, row1);
        addMapping(map, row2);
        addMapping(map, row3);

        // 还原字符串
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            result.append(map.get(c));  // 根据映射替换字符
        }

        // 输出还原后的字符串
        System.out.println(result.toString());
    }

    // 辅助方法：根据键盘行反转字符位置
    private static void addMapping(Map<Character, Character> map, String row) {
        int len = row.length();
        for (int i = 0; i < len; i++) {
            map.put(row.charAt(i), row.charAt(len - 1 - i));  // 反转位置映射
        }
    }
}
