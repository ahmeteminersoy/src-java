package src;

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
    private static String formatCalendar(Calendar cal) {
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1; // Ay 0'dan başlar, bu yüzden 1 ekleyin
        int year = cal.get(Calendar.YEAR);

        // İki haneli gün ve ay varsa önlerine sıfır ekle
        String dayStr = String.format("%02d", day);
        String monthStr = String.format("%02d", month);

        // Tarihi dd/mm/yyyy formatında döndür
        return dayStr + "/" + monthStr + "/" + year;
    }

    @Override
    public String toString() {
        return "Product [" +
                "productName='" + productName + '\'' +
                ", transactionDate=" + formatCalendar(saleDate) +
                ", price=" + price +
                ']';
    }
}
