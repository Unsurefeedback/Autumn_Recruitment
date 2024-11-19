package Sort;

import java.util.Arrays;

/**
 * @author WeiHanQiang
 * @date 2024/11/18 10:43
 **/
public class Sort {
    /**
     * 冒泡排序
     * swap 标志，当前一轮没有进行交换时，说明数组已经有序，不必进行下一轮循环，直接退出
     * 两层 for 循环，外层从后往前缩小排序范围，因为外面的 for 循环每次循环都会推出一个最大的元素到末尾
     * 里层的 for 循环，从头开始两两比较，把大的换到后面去
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean swap;
        for (int i = arr.length - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
                System.out.println(Arrays.toString(arr));
            }
            if(swap == false){
                break;
            }
            System.out.println("______");
        }

    }

    /**
     * 选择排序
     * 定义最小值的下标 min,每次 for 循环，把最小的往前放
     * @param arr
     */
    public static void selectionSort(int[] arr){
        int temp , min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min != i){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 插入排序
     * 外层 for 循环构建有序排列
     * 内层 while 循环不断比对，找到当前元素应该插入的 position
     * 把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
     * 从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
     * 重复上述过程直到最后一个元素被插入有序子数组中。
     * @param arr
     */
    public static void insertionSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int position = i;
            while(position > 0 && arr[position - 1] > value){
                arr[position] = arr[position-1];
                position--;
            }
            arr[position] = value;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 计数排序，通过计数而不是比较的方式来排序，需要知道最大值和最小值
     * 分为三个数组，原始数组 a,计数数组 count,累计数组 count,最终结果 b
     * 先遍历 a 数组,得到计数数组 count,里面记录了每个元素的数量,需要通过 num - min 的方式定位
     * 计算前缀和,知道每个元素的排名位置，累计就相当于每个人数一下自己前面有多少个人
     * 根据前缀和得到结果数组,注意：取出 count[num-min] 需要 -1 作为索引，每次排序完一个数字,count[num-min]--自减
     * @param a
     * @param max
     * @param min
     */
    public static void countSort(int[] a, int max, int min){
        int[] b = new int[a.length];
        int[] count = new int[max - min + 1];

        // 初始化数组
        for(int num = min; num <= max; num++){
            count[num - min] = 0;
        }
        // 统计每个数字出现的次数
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            count[num - min]++;
        }
        // 计算前缀和，后面会根据前缀和得到对应数字的排位索引
        for (int num = min + 1; num <= max; num++) {
            count[num - min] += count[num - min - 1];
        }

        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            // 获取排序后该数的索引
            int index = count[num - min] - 1;
            // 将数放到结果数组中
            b[index] = num;
            // 更新 前缀和 数组
            count[num - min]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 希尔排序
     * 第一层 for 循环,控制增量 delta
     * 第二层 for 循环,从当前增量开始,处理每个元素
     * 第三层 for 循环,对子序列进行插入排序,从后往前插
     * @param arr
     */
    public static void shellSort(int[] arr){
        int temp;
        for(int delta = arr.length/2; delta >= 1 ; delta /= 2){
            for (int i = delta; i < arr.length; i++) {
                for(int j = i; j >= delta && arr[j] < arr[j-delta]; j -= delta){
                    temp = arr[j-delta];
                    arr[j-delta] = arr[j];
                    arr[j] = temp;
                }
                System.out.println("————————————");
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 快速排序，分治的方式，不停地选出基准
     * 通过 while 循环把基准放在准确的位置
     * while 循环中，左指针找到比 基准值大的数值，填到右指针的位置
     * 右指针找到比基准值小的数值，填到左指针的位置
     * @param array
     */
    public static void quickSort(int[] array) {
        System.out.println("原始数组: " + Arrays.toString(array));
        qSort(array, 0, array.length - 1);
        System.out.println("排序后数组: " + Arrays.toString(array));
    }


    public static void qSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        System.out.println("当前区间: [" + low + ", " + high + "]");
        int pivot = partition(arr, low, high);
        System.out.println("以元素 " + arr[pivot] + " 为基准分区: " + Arrays.toString(arr));
        qSort(arr, low, pivot - 1);
        qSort(arr, pivot + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        System.out.println("选择基准元素: " + pivot);
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                // 能进入这个 while 循环，说明大于基准，应该放在左边，所以移动指针，不改变数组
                --high;
            }
            // 填坑，把比 pivot 小的 arr[high] 放在 arr[low]的位置
            // high 的循环要先写，因为 pivot 保存了 arr[row] 的值，可以被覆盖
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }
        // 左右指针相遇，留下的位置就是给 pivot 的
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 3, 5, 1, 4};
        // bubbleSort(array);
        // selectionSort(array);
        // insertionSort(array);
        // countSort(array,6,1);
        // shellSort(array);
        quickSort(array);
    }
}
