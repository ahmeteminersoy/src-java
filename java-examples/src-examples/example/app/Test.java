package example.app;

import java.util.ArrayList;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        Department accountingDepartment = new Department(1,"Accounting");
        Department marketingDepartment = new Department(2,"Marketing");
        Calendar cl1 = Calendar.getInstance();

        cl1.set(2023, Calendar.MAY, 1);
        Project autoCredit = new Project("AutoCredit", cl1, "Open");

        Calendar cl2 = Calendar.getInstance();
        cl2.set(2023, Calendar.DECEMBER, 1);
        Project atm = new Project("ATM", cl2, "Open");

        Calendar cl3 = Calendar.getInstance();
        cl3.set(2022, Calendar.MAY, 1);
        Project creditCart = new Project("CreditCard", cl3, "Close");

        Calendar cl4 = Calendar.getInstance();
        cl4.set(2021, Calendar.MAY, 1);
        Project robotic = new Project("Robotic", cl4, "Open");

        Calendar cl5 = Calendar.getInstance();
        cl5.set(2023, Calendar.JULY, 1);
        Project llm = new Project("LLM", cl5, "Open");

        Calendar cl6 = Calendar.getInstance();
        cl6.set(2023, Calendar.SEPTEMBER, 1);
        Project speechRecognition = new Project("SpeechRecognition", cl6, "Open");

        Calendar cl7 = Calendar.getInstance();
        cl7.set(2022, Calendar.NOVEMBER, 1);
        Project mobilApp = new Project("MobilApp", cl7, "Open");


        Calendar cl8 = Calendar.getInstance();
        cl8.set(2023, Calendar.JANUARY, 1);
        Product product1 = new Product("Product1", cl8, 10_000);

        Calendar cl9 = Calendar.getInstance();
        cl9.set(2023, Calendar.FEBRUARY, 1);
        Product product2 = new Product("Product2", cl9, 1_500);

        Calendar cl10 = Calendar.getInstance();
        cl10.set(2023, Calendar.NOVEMBER, 1);
        Product product3 = new Product("Product3", cl10, 15_000);

        Calendar cl11 = Calendar.getInstance();
        cl11.set(2024, Calendar.APRIL, 1);
        Product product4 = new Product("Product4", cl11, 50_000);

        Calendar cl12 = Calendar.getInstance();
        cl12.set(2023, Calendar.JANUARY, 11);
        Product product5 = new Product("Product5", cl12, 90_000);

        //Ayşe Çalışkan
        Calendar cl13 = Calendar.getInstance();
        cl13.set(1986, Calendar.MAY, 5);
        Person p1 = new Person(111, "Ayşe", "Çalışkan", "Woman", cl13, "Married", "Yes");

        // Mehmet Ari
        Calendar cl14 = Calendar.getInstance();
        cl14.set(1982, Calendar.JUNE, 9);
        Person p2 = new Person(123, "Mehmet", "Ari", "Man", cl14, "Single", "Yes");

        // İsmail Celik
        Calendar cl15 = Calendar.getInstance();
        cl15.set(1988, Calendar.JUNE, 9);
        Person p3 = new Person(145, "İsmail", "Çelik", "Man", cl15, "Married", "Yes");

        // Bulut Karadag
        Calendar cl16 = Calendar.getInstance();
        cl16.set(1979, Calendar.JULY, 23);
        Person p4 = new Person(156, "Bulut", "Karadağ", "Man", cl16, "Single", "Yes");

        // Serkan Yildiz
        Calendar cl17 = Calendar.getInstance();
        cl17.set(1990, Calendar.SEPTEMBER, 25);
        Person p5 = new Person(167, "Serkan", "Yıldız", "Man", cl17, "Married", "Yes");

        // Cevdet Balci
        Calendar cl18 = Calendar.getInstance();
        cl18.set(1988, Calendar.NOVEMBER, 28);
        Person p6 = new Person(178, "Cevdet", "Balci", "Man", cl18, "Married", "No");

        // Taner Eser
        Calendar cl19 = Calendar.getInstance();
        cl19.set(1967, Calendar.JANUARY, 9);
        Person p7 = new Person(189, "Taner", "Eser", "Man", cl19, "Single", "Yes");

        // Mustafa Emir
        Calendar cl20 = Calendar.getInstance();
        cl20.set(1989, Calendar.APRIL, 5);
        Person p8 = new Person(213, "Mustafa", "Emir", "Man", cl20, "Married", "Yes");

        // Hacer Paksoy
        Calendar cl21 = Calendar.getInstance();
        cl21.set(1998, Calendar.FEBRUARY, 1);
        Person p9 = new Person(224, "Hacer", "Paksoy", "Woman", cl21, "Married", "Yes");

        // Ela Kara
        Calendar cl22 = Calendar.getInstance();
        cl22.set(1989, Calendar.SEPTEMBER, 24);
        Person p10 = new Person(236, "Ela", "Kara", "Woman", cl22, "Married", "No");

        // Fatma Esin
        Calendar cl23 = Calendar.getInstance();
        cl23.set(1976, Calendar.NOVEMBER, 18);
        Person p11 = new Person(247, "Fatma", "Esin", "Woman", cl23, "Single", "Yes");

        // Arzu Ozturk
        Calendar cl24 = Calendar.getInstance();
        cl24.set(1967, Calendar.DECEMBER, 17);
        Person p12 = new Person(256, "Arzu", "Öztürk", "Woman", cl24, "Married", "Yes");

        // Selin Ergul
        Calendar cl25 = Calendar.getInstance();
        cl25.set(1988, Calendar.JULY, 9);
        Person p13 = new Person(267, "Selin", "Ergül", "Woman", cl25, "Single", "No");

        Calendar cl26 = Calendar.getInstance();
        cl26.set(2015, Calendar.MAY,22);
        Employee e1 = new Employee(p2, 50_000, cl26, accountingDepartment);
        Manager m1 = new Manager(e1, 15_000);

        Calendar cl27 = Calendar.getInstance();
        cl27.set(2017, Calendar.OCTOBER,10);
        Employee e2 = new Employee(p1, 35_000, cl27, marketingDepartment);
        RegularEmployee re1 = new RegularEmployee(e2, 25);

        Calendar cl28 = Calendar.getInstance();
        cl28.set(2018, Calendar.NOVEMBER,15);
        Employee e3 = new Employee(p4, 50_000, cl28, accountingDepartment);

        RegularEmployee re2 = new RegularEmployee(e3, 75);

        ArrayList<Project> projectArrayList1 = new ArrayList<>();
        projectArrayList1.add(creditCart);
        projectArrayList1.add(robotic);
        Developer de1 = new Developer(re1, projectArrayList1);

        Calendar cl29 = Calendar.getInstance();
        cl29.set(2015, Calendar.FEBRUARY, 14);
        Employee e4 = new Employee(p5, 75_000, cl29, accountingDepartment);

        RegularEmployee re3 = new RegularEmployee(e4, 50);
        ArrayList<Product> productArrayList1 = new ArrayList<>();
        productArrayList1.add(product5);
        productArrayList1.add(product1);
        SalesEmployee se1 = new SalesEmployee(re3, re3.getPerformanceScore(), productArrayList1);

        ArrayList<Product> productArrayList2 = new ArrayList<>();
        productArrayList2.add(product1);
        productArrayList2.add(product2);
        productArrayList2.add(product5);
        Customer c1 = new Customer(p9, productArrayList2);

        ArrayList<Product> productArrayList3 = new ArrayList<>();
        productArrayList3.add(product3);
        Customer c2 = new Customer(p13, productArrayList3);

        Calendar cl30 = Calendar.getInstance();
        cl30.set(2014, Calendar.MAY,24);
        Employee e5 = new Employee(p8, 10_000, cl30, marketingDepartment);
        RegularEmployee re4 = new RegularEmployee(e5, 100);
        ArrayList<Product> productArrayList4 = new ArrayList<>();
        productArrayList4.add(product1);
        productArrayList4.add(product2);
        productArrayList4.add(product3);
        SalesEmployee se2 = new SalesEmployee(re4, re4.getPerformanceScore(), productArrayList4);

        Calendar cl31 = Calendar.getInstance();
        cl31.set(2010, Calendar.MAY, 24);
        Employee e6 = new Employee(p12, 150_000, cl31, marketingDepartment);
        Manager m2 = new Manager(e6, 200_000);

        Calendar cl32 = Calendar.getInstance();
        cl32.set(2016, Calendar.NOVEMBER,4);
        Employee e7 = new Employee(p11, 50_000, cl32, marketingDepartment);
        RegularEmployee re5 = new RegularEmployee(e7, 80);
        ArrayList<Project> projectArrayList2 = new ArrayList<>();
        projectArrayList2.add(llm);
        projectArrayList2.add(speechRecognition);
        projectArrayList2.add(atm);
        Developer de2 = new Developer(re5, projectArrayList2);

        ArrayList<Product> productArrayList5 = new ArrayList<>();
        productArrayList5.add(product2);
        productArrayList5.add(product3);
        Customer c3 = new Customer(p6, productArrayList5);
    }

}
