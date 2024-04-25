package marmara.termproject.elements.items;


import marmara.termproject.elements.items.abstracts.item;

public class RoadTile extends item {
    private int type;
    private int rotation;

    private double x;
    private double y;

    public RoadTile(int type, int rotation, double x, double y) {
        this.type = type % 4;
        this.rotation = rotation / 90;
        this.x = x;
        this.y = y;
    }
}
