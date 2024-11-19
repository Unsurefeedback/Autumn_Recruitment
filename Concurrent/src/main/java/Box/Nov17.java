package Box;

import java.util.*;

/**
 * @author WeiHanQiang
 * @date 2024/11/17 20:12
 **/
public class Nov17 {
    public static void printMap(){
        Map<Integer,String> map = new HashMap<>(10);
        map.put(1,"Allen");
        map.put(2,"Bob");
        map.put(3,"Carlo");

        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        for (Integer i : map.keySet()){
            String value = map.get(i);
            System.out.println("Key: " + i + " Value: " + value);
        }

        for (String str : map.values()){
            System.out.println(str);
        }
        map.forEach((key,value)-> System.out.println("Key: "+key +" value: "+value));

        Iterator<Map.Entry<Integer,String >> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
    static class Student implements Comparable<Student>{
        Integer age;
        String name;

        public  Student(Integer age,String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Student other) {
            return other.age - this.age;
        }
    }

    static class Teacher {
        Integer age;
        String name;

        public  Teacher(Integer age,String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(11,"Bob");
        Student s2 = new Student(14,"Apple");
        Student s3 = new Student(10,"Apple");
        List<Student> students = new ArrayList<>(10);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students);
        students.forEach(student -> System.out.println(student.name + ": " + student.age));

        Teacher t1 = new Teacher(1,"!");
        Teacher t2 = new Teacher(199,"Permission");
        Teacher t3 = new Teacher(18,"to");
        Teacher t4 = new Teacher(195,"be");
        Teacher t5 = new Teacher(193,"human");
        List<Teacher> teachers = new ArrayList<>(10);
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);
        teachers.add(t5);
        Comparator<Teacher> comparator = new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o2.age - o1.age;
            }
        };
        Collections.sort(teachers,comparator);
        teachers.forEach(teacher -> System.out.print(teacher.name+" "));
    }

}
