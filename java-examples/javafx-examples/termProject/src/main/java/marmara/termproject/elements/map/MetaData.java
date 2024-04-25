package marmara.termproject.elements.map;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MetaData {
    private double width;
    private double height;
    private int cellsInXDirection;
    private int cellsInYDirection;
    private int paths;
    private int winGame;
    private int allowedCars;

    public MetaData(double width, double height, int cellsInXDirection, int cellsInYDirection, int paths, int winGame,
                    int allowedCars) {
        this.width = width;
        this.height = height;
        this.cellsInXDirection = cellsInXDirection;
        this.cellsInYDirection = cellsInYDirection;
        this.paths = paths;
        this.winGame = winGame;
        this.allowedCars = allowedCars;
    }
    public Pane make(){
        double cellWidth = width / cellsInXDirection;
        double cellHeight = height / cellsInYDirection;
        Pane gridPane= new Pane();

        for (int i = 0; i < cellsInXDirection; i++)
            for (int j = 0; j < cellsInYDirection; j++)
            {
                Rectangle cell = new Rectangle(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                cell.setStroke(Color.BLACK);
                cell.setFill(Color.ORANGE);
                gridPane.getChildren().add(cell);
            }
        return gridPane;
    }
}
