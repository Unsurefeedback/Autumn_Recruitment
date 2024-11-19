package Box; /**
 * @author WeiHanQiang
 * @date 2024/11/12 09:18
 **/
import java.util.*;
public class HuaWei {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String target = sc.next();
        // String guessNumber = sc.next();
        // select name,SUM(score),AVG(score) from student group by name
        System.out.println(guessNumber("5346","5234"));
        System.out.println(guessNumber("5346","1234"));
        System.out.println(guessNumber("5346","6534"));
        System.out.println(guessNumber("5346","5364"));
        String  in = "ABCDE";
        int length = in.length();
        char[] str = in.toCharArray();
        str[length] = '!';
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            map.put(str[i], map.getOrDefault(str[i],0)+1);
        }

    }
    public static String guessNumber(String target, String guessNumber) {
        int numA = 0;
        int numB = 0;
        int length = target.length();
        int[] targetArray = new int[10];
        int[] guessArray = new int[10];
        for(int i =0; i < length; i++){
            char charTarget = target.charAt(i);
            char charGuess = guessNumber.charAt(i);
            if(charGuess == charTarget){
                numA++;
            }else{
                targetArray[charTarget-'0']++;
                guessArray[charGuess-'0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if(targetArray[i]==guessArray[i]){
                numB+=Math.min(targetArray[i],guessArray[i]);
            }
        }

        return numA + "A"+numB+"B";
    }

}
