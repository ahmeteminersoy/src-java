import java.lang.ref.WeakReference;

public class App {
    public static void main(String[] args) {

    }

}
class Circle {
    private final static double PI = 3.1415;
    private double rad;
    private double x;
    private double y;

    public Circle(double rad, double x, double y) {
        this.rad = rad;
        this.x = x;
        this.y = y;
    }

    public Circle(int rad) {
        this.rad = rad;
    }

    public double calculateArea() {
        return PI * rad * rad;
    }

    public double getRad() {
        return rad;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}