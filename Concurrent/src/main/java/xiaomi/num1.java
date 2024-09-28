/*
package xiaomi;

import java.util.Scanner;

*/
/**
 * @author WeiHanQiang
 * @date 2024/09/08 16:32
 **//*

public class num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] sum = new int[n];
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            a[j] = scanner.nextInt();
            minA = Math.min(minA,a[j]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            minB = Math.min(minB,b[i]);
        }
        for (int i = 0; i < n; i++) {
            sum[i] = a[i] + b[i];
            minSum = Math.min(minSum,sum[i]);
        }
        System.out.println(Math.min(minSum,minB+minA));
        scanner.close();
    }
}
*/
package xiaomi;

import java.util.Scanner;

/**
 * @author WeiHanQiang
 * @date 2024/09/08 16:32
 **/
public class num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取数组长度
        int[] a = new int[n];
        int[] b = new int[n];
        int[] sum = new int[n];
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        // 读取 a 数组的元素
        for (int j = 0; j < n; j++) {
            a[j] = scanner.nextInt();
            minA = Math.min(minA, a[j]);
        }

        // 读取 b 数组的元素
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            minB = Math.min(minB, b[i]);
        }

        // 计算 sum 数组的元素
        for (int i = 0; i < n; i++) {
            sum[i] = a[i] + b[i];
            minSum = Math.min(minSum, sum[i]);
        }

        // 输出最小值
        System.out.println(Math.min(minSum, minB + minA));
        scanner.close();
    }
}
