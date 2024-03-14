import java.util.ArrayList;
import java.util.Random;

public class Teacher extends Person{
    private double salary;
    public ArrayList<String> coursesGiven;

    public Teacher(String name, int birthYear, boolean isFemale, double salary) {
        super(name, birthYear, isFemale);
        this.coursesGiven = new ArrayList<>();
        this.salary = salary;
    }
    public void giveCourse(String courseName)
    {
        coursesGiven.add(courseName);
    }
    public void giveGrade(ArrayList<String> studentNames, String courseName)
    {
        Random r = new Random();

        for (String studentName: studentNames)
            System.out.printf("%s, %s, %s%n",studentName, courseName, generateRandomLetterGrade(r));;

    }
    private static String generateRandomLetterGrade(Random r)
    {
        return switch (r.nextInt(8)){
            case 0 -> "AA";
            case 1 -> "BA";
            case 2 -> "BB";
            case 3 -> "CB";
            case 4 -> "CC";
            case 5 -> "CD";
            case 6 -> "DD";
            case 7 -> "FF";
            default -> "None";
        };
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                ", coursesGiven=" + coursesGiven +
                "}\n";
    }
}
