import java.util.ArrayList;

public class Student extends  Person{
    private int id;
    private double gpa;
    public ArrayList<String> coursesTaken;

    public Student(String name, int birthYear, boolean isFemale, int id, double gpa) {
        super(name, birthYear, isFemale);
        this.id = id;
        this.coursesTaken = new ArrayList<>();
        this.gpa = gpa;
    }
    public void takeCourse(String courseName)
    {
        coursesTaken.add(courseName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +"\nStudent{" +
                "id=" + id +
                ", gpa=" + gpa +
                ", coursesTaken=" + coursesTaken +
                "}\n";
    }
}
