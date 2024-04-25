package marmara.termproject.elements.map;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import static marmara.termproject.runTraffic.metaData;

public class TrafficLight {
    private boolean isGreen;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public TrafficLight(double x1, double y1, double x2, double y2) {
        isGreen = true;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Node makeLine()
    {
        return new Line(x1, y1, x2, y2);
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

        return circle;
    }
}
