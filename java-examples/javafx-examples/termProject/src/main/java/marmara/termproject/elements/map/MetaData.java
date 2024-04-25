package marmara.termproject.elements.map;

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
}
