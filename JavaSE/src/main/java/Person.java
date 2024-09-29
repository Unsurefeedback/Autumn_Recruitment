/**
 * @author WeiHanQiang
 * @date 2024/09/29 14:39
 **/
class Person implements Cloneable {
    String name;
    int age;
    Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(Person person1) {
        this.age = person1.age;
        this.name = person1.name;
        this.address = person1.address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}



