package example.app;

import java.util.Calendar;

public class Product {
    private String productName;
    private Calendar saleDate;
    private double price;

    public Product(String productName, Calendar saleDate, double price) {
        this.productName = productName;
        this.saleDate = saleDate;
        this.price = price;
    }

    public Calendar getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Calendar saleDate) {
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", saleDate=" + saleDate +
                ", price=" + price +
                '}';
    }
}
