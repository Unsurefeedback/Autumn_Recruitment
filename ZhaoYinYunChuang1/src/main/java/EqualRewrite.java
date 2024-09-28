/**
 * @author WeiHanQiang
 * @date 2024/09/24 14:20
 **/
public class EqualRewrite {
    private final char value[];

    public EqualRewrite(char[] value) {
        this.value = value;
    }

    public static void main(String[] args) {
        String a = new String("www");

    }

/*     public boolean equals1(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    } */
}
