package src;

import java.util.Calendar;

public class RegularEmployee extends Employee{
    private double performanceScore;
    private double bonus;

    public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
                           String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate,
                           Department department, double performanceScore) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
        this.performanceScore = performanceScore;
    }

    public RegularEmployee(Employee employee, double performanceScore) {
        super(employee, employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        this.performanceScore = performanceScore;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() +"\nRegularEmployee Info [" +
                "performanceScore=" + performanceScore +
                ", bonus=" + bonus +
                ']';
    }
}
