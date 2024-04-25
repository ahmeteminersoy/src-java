package marmara.termproject.elements.map;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MetaData {
    private double width;
    private double height;
    private int cellsInXDirection;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCellsInXDirection() {
        return cellsInXDirection;
    }

    public void setCellsInXDirection(int cellsInXDirection) {
        this.cellsInXDirection = cellsInXDirection;
    }

    public int getCellsInYDirection() {
        return cellsInYDirection;
    }

    public void setCellsInYDirection(int cellsInYDirection) {
        this.cellsInYDirection = cellsInYDirection;
    }

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
                cell.setStroke(Color.CYAN);
                cell.setFill(Color.LIGHTCYAN);
                cell.setStrokeWidth(0.2);
                gridPane.getChildren().add(cell);
            }
        return gridPane;
    }
}
