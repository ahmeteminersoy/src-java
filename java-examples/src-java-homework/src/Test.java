package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Test {
    public static ArrayList<Department> departments = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
    public static ArrayList<SalesEmployee> salesEmployees = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Project> projects = new ArrayList<>();
    public static ArrayList<Person> people = new ArrayList<>();
    public static ArrayList<Developer> developers = new ArrayList<>();
    public static ArrayList<Manager> managers = new ArrayList<>();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        {
            String inputTextAddress = "/Users/ahmeteminersoy/Documents/src/src-java/java-examples/src-examples/src/input.txt";
            String outputTextAddress = "/Users/ahmeteminersoy/Documents/src/src-java/java-examples/src-examples/src/output.txt";
            try (FileWriter fileWriter = new FileWriter(outputTextAddress))
            {

                FileReader fileReader = new FileReader(inputTextAddress);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;

                ArrayList<String> lines = new ArrayList<>();
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line);
                }
                for(String str : lines)
                {
                    if (str.isEmpty())
                        continue;
                    String []  tokens = str.split(" ");
                    execute(tokens);
                }
                for (Manager m : managers)
                    for (RegularEmployee re : regularEmployees)
                    {
                        if (m.getDepartment() == re.getDepartment())
                            m.addEmployee(re);
                    }
                for (Manager m: managers)
                {
                    m.distributeBonusBudget();
                    m.raiseSalary(0.2);
                }


                for (RegularEmployee re: regularEmployees)
                    re.raiseSalary(0.3);

                for (Developer de: developers)
                {
                    de.raiseSalary(0.23);
                }

                for (SalesEmployee se : salesEmployees)
                    se.raiseSalary(0.18);

                double max = 0;
                SalesEmployee maximumSales = salesEmployees.getFirst();
                for (SalesEmployee se: salesEmployees)
                {
                    double value = 0;
                    for (Product p : se.getSales())
                        value += p.getPrice();
                    if (value > max)
                    {
                        max = value;
                        maximumSales = se;
                    }
                }
                maximumSales.raiseSalary(10000);






                for (Department dep : departments)
                {
                    fileWriter.write("***********************************************************\n");
                    fileWriter.write(dep + "\n");
                    for (Manager m : managers)
                        if (m.getDepartment() == dep)
                            fileWriter.write( m + "\n");;
                    fileWriter.write( "\n");

                    for (Developer dev : developers)
                    {

                        if (dev.getDepartment() == dep)
                        {
                            fileWriter.write( "Developer\n");
                            fileWriter.write( dev + "\n");
                        }
                    }
                    fileWriter.write( "\n");
                    for (SalesEmployee se : salesEmployees)
                    {
                        if (se.getDepartment() == dep)
                        {
                            fileWriter.write( "Sales Employee\n");
                            fileWriter.write( se + "\n");
                        }

                    }
                    fileWriter.write( "\n");
                    for (RegularEmployee re : regularEmployees)
                    {
                        if (re.getDepartment() == dep && !isDeveloper(re) && !isSalesEmployee(re))
                        {
                            fileWriter.write( "Regular Employee\n");
                            fileWriter.write( re + "\n");
                        }

                    }
                    fileWriter.write( "\n");
                }
                fileWriter.write( "**********************CUSTOMERS************************" + "\n");

                for (Customer c : customers)
                    if(c.getProducts().getFirst() != null)
                        fileWriter.write( c + "\n");
                fileWriter.write( "**********************PEOPLE************************\n");

                for (Person p : people)
                    if (!isCustomer(p) && !isEmployee(p))
                        fileWriter.write( p + "\n");

            }
            catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
            }

            // Perform operations as described in the assignment
            // For example, creating employees, customers, etc.

            // Print results to output.txt file
        }
    }
    public static void execute(String [] tokens)
    {
        switch (tokens[0]) {
            case "Department":
            {
                int departmentId = Integer.parseInt(tokens[1]);
                String departmentName = tokens[2];
                Department department = new Department(departmentId, departmentName);
                departments.add(department);
                break;
            }

            case "Project":
                String projectName = tokens[1];
                Calendar startDate = Calendar.getInstance();
                // Parse startDate from tokens[2]
                String state = tokens[3];
                Project project = new Project(projectName, startDate, state);
                projects.add(project);
                break;
            case "Product":
                String productName = tokens[1];
                Calendar saleDate = parseCalendar(tokens[2]);
                double price = Double.parseDouble(tokens[3]);
                Product product = new Product(productName, saleDate, price);
                products.add(product);
                break;
            case "Person":

                String firstName = tokens[1];
                String lastName = tokens[2];
                int id = Integer.parseInt(tokens[3]);
                String gender = tokens[4];
                Calendar birthDate = parseCalendar(tokens[5]);
                String maritalStatus = tokens[6];
                String hasDriverLicense = tokens[7];
                Person person = new Person(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
                people.add(person);
                break;
            case "Employee":
                int employeeId = Integer.parseInt(tokens[1]);
                double salary = Double.parseDouble(tokens[2]);
                Calendar hireDate = parseCalendar(tokens[3]);
                Department department = findDepartment(tokens[4]); // You need to implement this method
                Employee employee = new Employee(findPerson(employeeId), salary, hireDate, department);
                employees.add(employee);
                break;
            case "RegularEmployee":
                int regularEmployeeId = Integer.parseInt(tokens[1]);
                double regularEmployeePerformanceScore = Double.parseDouble(tokens[2]);
                RegularEmployee regularEmployee = new RegularEmployee(findEmployee(regularEmployeeId), regularEmployeePerformanceScore);
                regularEmployees.add(regularEmployee);
                break;
            case "Manager":
                int managerId = Integer.parseInt(tokens[1]);
                double bonusBudget = Double.parseDouble(tokens[2]);
                Manager manager = new Manager(findEmployee(managerId), bonusBudget);
                managers.add(manager);
                break;
            case "SalesEmployee":
                int salesEmployeeId = Integer.parseInt(tokens[1]);
                ArrayList<Product> sales = new ArrayList<>();
                for (int i = 2; i < tokens.length; i++) {
                    sales.add(findProduct(tokens[i]));
                }
                SalesEmployee salesEmployee = new SalesEmployee(findRegularEmployee(salesEmployeeId), sales);
                salesEmployees.add(salesEmployee);
                break;
            case "Developer":
                int developerId = Integer.parseInt(tokens[1]);
                ArrayList<Project> developerProjects = new ArrayList<>();
                for (int i = 2; i < tokens.length; i++) {
                    developerProjects.add(findProject(tokens[i]));
                }
                Developer developer = new Developer(findRegularEmployee(developerId),developerProjects);
                developers.add(developer);
            case "Customer":
                int customerId = Integer.parseInt(tokens[1]);
                ArrayList<Product> customerProducts = new ArrayList<>();
                for (int i = 2; i < tokens.length; i++) {
                    customerProducts.add(findProduct(tokens[i]));
                }
                Customer customer = new Customer(findPerson(customerId), customerProducts);
                customers.add(customer);
                break;
            default:
                break;
        }

    }
    private static Calendar parseCalendar(String dateStr) {
        Calendar calendar = Calendar.getInstance();
        String[] tokens = dateStr.split("/");
        int[] intTokens = Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
        calendar.set(intTokens[2], intTokens[1] - 1, intTokens[0]);
        return calendar;
    }
    private static Person findPerson(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    private static Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    private static Product findProduct(String name) {
        for (Product product : products) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }


    private static Department findDepartment(String id) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(id)) {
                return department;
            }
        }
        return null;
    }

    private static RegularEmployee findRegularEmployee(int id) {
        for (RegularEmployee regularEmployee : regularEmployees) {
            if (regularEmployee != null && regularEmployee.getId() == id) {
                return regularEmployee;
            }
        }
        return null;
    }

    private static Project findProject(String name) {
        for (Project project : projects) {
            if (project.getProjectName().equals(name)) {
                return project;
            }
        }
        return null;
    }
    private static boolean isDeveloper(RegularEmployee employee)
    {
        for (Developer de : developers)
            if (de.getId() == employee.getId())
                return true;
        return false;
    }
    private static boolean isSalesEmployee(RegularEmployee employee)
    {
        for (SalesEmployee se : salesEmployees)
            if (se.getId() == employee.getId())
                return true;
        return false;
    }
    private static boolean isCustomer(Person person)
    {
        for (Customer c: customers)
            if (c.getId() == person.getId())
                return true;
        return false;
    }
    private static boolean isEmployee(Person person)
    {
        for (Employee e: employees)
            if (e.getId() == person.getId())
                return true;
        return false;
    }
}
