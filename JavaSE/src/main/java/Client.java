/**
 * @author WeiHanQiang
 * @date 2024/09/29 14:40
 **/
import java.util.*;
@SuppressWarnings("all")
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("河南省洛阳市");
        Person person1 = new Person("沉默王二", 18, address);
        Person person2 = (Person) person1.clone();
        System.out.println("Person 类实现了 Cloneable 接口，浅拷贝。");
        System.out.println(person1.address == person2.address); // true

        System.out.println("——————————————");
        System.out.println("Person 类内部构造方法，浅拷贝");
        Person person3 = new Person(person1);
        System.out.println(person1.address == person3.address); // true

    }
}
