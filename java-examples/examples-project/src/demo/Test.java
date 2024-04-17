package demo;


public class Test {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(5);

        if (circle1.equals(circle2))
            System.out.println("AYNI");
        else {
            System.out.println("Değil");
        }

    }
}
class Circle {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean equals(Circle o) {
        if (this.radius == ((Circle)o).radius)
            return true;
        return false;

    }


}


