package Clone; /**
 * @author WeiHanQiang
 * @date 2024/09/29 14:40
 **/
import java.io.IOException;

@SuppressWarnings("all")
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Address address = new Address("河南省洛阳市");
        Person person1 = new Person("沉默王二", 18, address);
        Person person2 = (Person) person1.clone();
        System.out.println("Clone.Person 类实现了 Cloneable 接口实现: 浅拷贝。");
        System.out.println("person1.address == person2.address : " + (person1.address == person2.address)); // true

        System.out.println("——————————————");
        System.out.println("Clone.Person 类内部构造方法实现: 浅拷贝");
        Person person3 = new Person(person1);
        person3.name.concat("1");
        System.out.println("person1.address == person3.address : " + (person1.address == person3.address)); // true

        System.out.println("——————————————");
        System.out.println("Clone.SuperMan 类内部通过序列化和反序列化实现: 深拷贝");
        SuperMan superMan = new SuperMan("月球",90);
        SuperMan superMan1 = superMan.deepClone();
        System.out.println("superMan.planet == superMan1.planet : " + (superMan.planet == superMan1.planet));
    }
}
