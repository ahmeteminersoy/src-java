package src;

import java.util.ArrayList;
import java.util.Calendar;

import static src.Test.developers;
import static src.Test.salesEmployees;

public class Manager extends Employee{
    private ArrayList<RegularEmployee> regularEmployees;
    private double bonusBudget;

    public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                   String hasDriverLicence, double salary, Calendar hireDate, Department department,double bonusBudget)
    {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
        this.bonusBudget = bonusBudget;
        regularEmployees = new ArrayList<>();
    }

    public Manager(Employee employee, double bonusBudget)
    {
        super(employee, employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        this.bonusBudget = bonusBudget;
        regularEmployees = new ArrayList<>();
    }
    public void addEmployee(RegularEmployee regularEmployee)
    {
        regularEmployees.add(regularEmployee);
    }
    public void removeEmployee(RegularEmployee regularEmployee)
    {
        regularEmployees.remove(regularEmployee);
    }
    public void distributeBonusBudget()
    {
        ArrayList<RegularEmployee> list = regularEmployees;
        list.addAll(developers);
        list.addAll(salesEmployees);

        for(RegularEmployee re : list)
        {
            re.setBonus(getTotalBonusScorePerUnit() * re.getSalary() * re.getPerformanceScore());
        }
    }
    private double getTotalBonusScorePerUnit()
    {
        double bonusScores = 0;
        for(RegularEmployee re : regularEmployees)
        {
            bonusScores += re.getSalary() * re.getPerformanceScore();
        }
        return bonusBudget/bonusScores;
    }

    public ArrayList<RegularEmployee> getRegularEmployees() {
        return regularEmployees;
    }

    public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
        this.regularEmployees = regularEmployees;
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    @Override
    public String toString() {
        return "Manager [" +
                "id: " + getId() +
                ", "+ getFirstName() +" "+ getLastName() + " # of Employees: " + regularEmployees.size() +
                ']';
    }
}
