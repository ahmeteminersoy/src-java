package marmara.termproject.elements.map;

import marmara.termproject.elements.items.Car;

public class Path {
    private int pathNumber;
    private String pathElement;
    private double x;
    private double y;

    public Path(int pathNumber, String pathElement, double x, double y) {
        this.pathNumber = pathNumber;
        this.pathElement = pathElement;
        this.x = x;
        this.y = y;
    }
}
