package example.app;

import java.util.Calendar;

public class Employee extends Person{
    private double salary;
    private Calendar hireDate;
    private Department department;
    public int numberofEmployees;


    public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                    String hasDriverLicence, double salary, Calendar hireDate, Department department) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
        this.numberofEmployees++;
    }


    public Employee(Person person, double salary, Calendar hireDate, Department department)
    {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
                person.getMaritalStatus(), person.isHasDriverLicence());
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
        this.numberofEmployees++;

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumberofEmployees() {
        return numberofEmployees;
    }

    public void setNumberofEmployees(int numberofEmployees) {
        this.numberofEmployees = numberofEmployees;
    }
    public double raiseSalary(double percent)
    {
        this.salary *=  1 + percent;
        return this.salary;
    }

    public double raiseSalary(int amount)
    {
        this.salary += amount;
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", hireDate=" + hireDate +
                ", department=" + department +
                ", numberofEmployees=" + numberofEmployees +
                '}';
    }
}
