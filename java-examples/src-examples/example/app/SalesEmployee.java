package example.app;

import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee{
    private ArrayList<Product> sales;
    public int numberOfSalesEmployees;

    public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
                         String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate,
                         Department department, double performanceScore, ArrayList<Product> sales) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
                department, performanceScore);
        this.sales = sales;
        numberOfSalesEmployees++;
    }

    public SalesEmployee(RegularEmployee regularEmployee, ArrayList<Product> sales) {
        super(regularEmployee, regularEmployee.getPerformanceScore());
        this.sales = sales;
        numberOfSalesEmployees++;
    }
    public boolean addSale(Product product)
    {
        sales.add(product);
        return false; //TODO
    }
    public boolean removeSale(Product product)
    {
        sales.remove(product);
        return false; //TODO
    }

    public ArrayList<Product> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }

    public int getNumberOfSalesEmployees() {
        return numberOfSalesEmployees;
    }

    public void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
        this.numberOfSalesEmployees = numberOfSalesEmployees;
    }
    public String getAllProductName()
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sales.size(); i++) {
            result.append(sales.get(i));
            if (i < sales.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "\n[" +
                getAllProductName() +
                ']';
    }
}
