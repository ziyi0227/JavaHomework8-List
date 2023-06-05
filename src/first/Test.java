package first;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("张三", "class1", "Java", 85));
        students.add(new Student("周乐儿", "class1", "C#", 79));
        students.add(new Student("王涛", "class2", "C#", 52));
        students.add(new Student("李明", "class2", "Java", 48));

        for (Student student : students){
            System.out.println("姓名：" + student.getName() +
                    "，班级：" + student.getClassName() +
                    "，课程：" + student.getCourseName() +
                    "，成绩：" + student.getScore());
        }

        int class1SumScore = 0;
        int class1Count = 0;
        for (Student student : students){
            if (student.getClassName().equals("class1")){
                class1SumScore += student.getScore();
                class1Count++;
            }
        }
        double class1AvgScore = (double) class1SumScore / class1Count;
        System.out.println("class1班的总分为：" + class1SumScore +
                "，平均分为：" + class1AvgScore);

        // 计算Java、C#课程的平均分
        int javaTotalScore = 0;
        int javaCount = 0;
        int cSharpTotalScore = 0;
        int cSharpCount = 0;
        for (Student student : students) {
            if (student.getCourseName().equals("Java")) {
                javaTotalScore += student.getScore();
                javaCount++;
            } else if (student.getCourseName().equals("C#")) {
                cSharpTotalScore += student.getScore();
                cSharpCount++;
            }
        }
        double javaAvgScore = (double) javaTotalScore / javaCount;
        double cSharpAvgScore = (double) cSharpTotalScore / cSharpCount;
        System.out.println("Java课程的平均分为：" + javaAvgScore);
        System.out.println("C#课程的平均分为：" + cSharpAvgScore);
    }
}
