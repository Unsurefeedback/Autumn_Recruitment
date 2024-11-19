package Box;

import java.util.Arrays;
import java.util.List;

/**
 * @author WeiHanQiang
 * @date 2024/11/19 10:32
 **/
public class Nov19 {

    public static void bubbleSort(int[] array){
        int temp = 0;
        boolean swap;
        for (int i = array.length - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swap = true;
                }
            }
            if(swap == false){
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array){
        int temp,min = 0;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length;j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if(min!=i){
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
        int[] array = new int[]{3,5,1,-2,4,2,88,1};
        // bubbleSort(array);
        // selectionSort(array);

        List<String> names = Arrays.asList("Amy","Bob","Charlie","David");

        long count = names.stream().filter(name->name.length() > 3).count();
        System.out.println("名字长度大于 3 的数量: " + count);
    }
}
