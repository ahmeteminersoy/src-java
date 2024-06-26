package marmara.termproject.elements.map;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import marmara.termproject.elements.items.abstracts.item;

import static marmara.termproject.runTraffic.metaData;

public class TrafficLight extends item {
    private boolean isGreen;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private Circle circle;
    private Line line;

    public TrafficLight(double x1, double y1, double x2, double y2) {
        isGreen = true;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Node makeLine()
    {
        this.line = new Line(x1, y1, x2, y2);
        return new Line(x1, y1, x2, y2);
    }

    public Circle getCircle() {
        return circle;
    }

    public Line getLine() {
        return line;
    }

    public Node makeLight()
    {
        double r = metaData.getWidth() / metaData.getCellsInXDirection() / 10;
        Circle circle = new Circle((x1 + x2) / 2, (y1 + y2) / 2, r);
        circle.setFill(Color.GREEN);
        circle.setOnMouseClicked(event -> {
            if (circle.getFill() == Color.GREEN) {
                circle.setFill(Color.RED);
                isGreen = false;
            } else {
                circle.setFill(Color.GREEN);
                isGreen = true;
            }
        });
        this.circle = circle;
        return circle;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
}
