package marmara.termproject.elements.items;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import marmara.termproject.elements.items.abstracts.item;

public class RoadTile extends item {
    public double width;
    public double height;
    public int xCellNumber;
    public int yCellNumber;
    private int type;
    private int rotation;
    private double x;
    private double y;

    public RoadTile(int type, int rotation, double x, double y) {
        this.type = type % 4;
        this.rotation = rotation;
        this.x = x; // Assuming x, y are grid positions, and each tile is 50 units
        this.y = y;
    }

    public Pane make() {
        Pane pane = new Pane();

        Rectangle base = new Rectangle(x*(width / xCellNumber),y * (height / yCellNumber), width / xCellNumber, height / yCellNumber);
        base.setFill(Color.GRAY);
        pane.getChildren().add(base);

        // Add center line or other road marks
        // Add curved or straight parts depending on type
        switch (type) {
            case 0: // Straight road, no additional shapes needed
                break;
            case 1: // Curved road
                //Arc curve = new Arc(x + 25, y + 25, 25, 25, 0, 90);
                //curve.setType(ArcType.OPEN);
                //curve.setStroke(Color.WHITE);
                //curve.setStrokeWidth(2);
                //curve.setFill(null); // No fill, just an arc
                //pane.getChildren().add(curve);
                break;
            case 2: // Intersection of four roads, add lines
                // Code to add lines for type 2
                break;
            case 3: // Intersection of three roads, add lines
                // Code to add lines for type 3
                break;
        }

        // Apply rotation to the entire pane
        //pane.setRotate(rotation);

        return pane;
    }
}