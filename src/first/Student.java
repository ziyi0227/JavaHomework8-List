package first;

public class Student {
    private String name;
    private String className;
    private String courseName;
    private int score;


    public Student(String name, String className, String courseName, int score) {
        this.name = name;
        this.className = className;
        this.courseName = courseName;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
