package Clone;

import java.io.*;

/**
 * @author WeiHanQiang
 * @date 2024/09/29 14:46
 **/
public class SuperMan implements Serializable {
    String planet;
    int age;

    public SuperMan(String planet, int age) {
        this.planet = planet;
        this.age = age;
    }

    public SuperMan deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (SuperMan) ois.readObject();
    }
}
