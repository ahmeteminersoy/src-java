package demo;

public class Faculty extends Employee {
    public static void main(String[] args) {
        new Faculty();
    }
    public Faculty()
    {
        System.out.println("Hi");
    }
}
class Employee extends Person {
    public Employee() {
        this("(2) Invoke demo.Employee’s overloaded constructor");
        System.out.println("(3) demo.Employee's no-arg constructor is invoked"); }
    public Employee(String s) {
        System.out.println(s);
    }
}
class Person {
    public Person() {
        System.out.println("(1) demo.Person's no-arg constructor is invoked"); }
}