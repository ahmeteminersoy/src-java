package example.app;

import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person{
    private ArrayList<Product> products;

    public Customer(int id, String firstName, String lastName, byte gender, Calendar birthDate, byte maritalStatus,
                    boolean hasDriverLicence, ArrayList<Product> products) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
        this.products = products;
    }

    public Customer(Person person, ArrayList<Product> products) {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
                person.getMaritalStatus(), person.isHasDriverLicence());
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer [id:" + super.getId()
                +
                "products=" + products +
                '}';
    }
}
