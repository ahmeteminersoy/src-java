import java.util.ArrayList;
import java.util.List;

public class quiz1_150123526 {
    public static void main(String[] args) {
        Person[] people = new Person[6];
        people[0] = new Teacher("Ahmet", 1992, false, 1000);
        people[1] = new Teacher("Mehmet", 1924, false, 10000);
        people[2] = new Student("Caner", 1934, false, 10000, 2);
        people[3] = new Student("Ayşe", 1964, true, 10000, 1);
        people[4] = new Student("Fatma", 1990, true, 10000, 0);
        people[5] = new Student("Buğra", 1991, false, 10000, 3);
        Teacher t1 = (Teacher) people[0];
        Teacher t2 = (Teacher) people[1];
        t1.coursesGiven.add("CS100");
        t1.coursesGiven.add("CS101");
        t2.coursesGiven.add("CS225");
        Student s1 = (Student) people[2];
        Student s2 = (Student) people[3];
        Student s3 = (Student) people[4];
        Student s4 = (Student) people[5];
        s1.takeCourse("CS100");
        s1.takeCourse("CS101");
        s1.takeCourse("CS225");

        s2.takeCourse("CS100");
        s2.takeCourse("CS101");
        s2.takeCourse("CS225");

        s3.takeCourse("CS100");
        s3.takeCourse("CS101");
        s3.takeCourse("CS225");

        s4.takeCourse("CS100");
        s4.takeCourse("CS101");
        s4.takeCourse("CS225");

        try
        {
            courseSchedule(people);
            for (Person person: people)
                System.out.println(person);
        }
        catch (NullPointerException e)
        {
            System.err.println(e.getMessage());
        }

    }
    public static void courseSchedule(Person[] people){
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String> studentsVariable = new ArrayList<>();
        for (Person person : people)
            if (person instanceof Student)
                students.add((Student)person);

        for (Person person : people)
            if (person instanceof Teacher)
            {
                for(String course: ((Teacher) person).coursesGiven)
                {
                    for (Student student: students)
                        if (student.coursesTaken.contains(course))
                        {
                            System.out.println(student.getName());
                            studentsVariable.add(student.getName());
                        }
                    ((Teacher) person).giveGrade(studentsVariable, course);
                    studentsVariable = new ArrayList<>();
                }
            }
    }


}

