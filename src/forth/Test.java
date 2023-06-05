package forth;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Tom", 20);
        Student s2 = new Student(2, "Jack", 21);
        Student s3 = new Student(3, "John", 22);
        Student s4 = new Student(4, "Tom", 20);
        Student s5 = new Student(5, "John", 22);

        HashSet<Student> set = new HashSet<Student>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        System.out.println("去重后的学生信息：");
        for (Student s : set) {
            System.out.println("sid:" + s.getSid() + ",  name:" + s.getName() + ", age:" + s.getAge());
        }
    }
}
