package example.app;

import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee{
    private ArrayList<Project> projects;
    public int numberOfDevelopers;

    public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                     String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore, ArrayList<Project> projects) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
                department, performanceScore);
        this.projects = projects;
        numberOfDevelopers++;
    }

    public Developer(RegularEmployee regularEmployee, ArrayList<Project> projects) {
        super(regularEmployee, regularEmployee.getPerformanceScore());
        this.projects = projects;
        numberOfDevelopers++;
    }
    public boolean addProject(Project project)
    {
        projects.add(project);
        return false; //TODO
    }
    public boolean removeProject(Project project)
    {
        projects.remove(project);
        return false; //TODO
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public void setNumberOfDevelopers(int numberOfDevelopers) {
        this.numberOfDevelopers = numberOfDevelopers;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "projects=" + projects +
                ", numberOfDevelopers=" + numberOfDevelopers +
                '}';
    }
}