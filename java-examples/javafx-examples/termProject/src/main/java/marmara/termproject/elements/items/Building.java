package marmara.termproject.elements.items;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import marmara.termproject.elements.items.abstracts.item;

public class Building extends item {
    private int type;
    private Color color;
    private int rotation;
    private int x;
    private int y;

    public Building(int type, int color, int rotation, int x, int y) {
        this.type = type % 4;
        this.color = Color.BLUE;
        this.rotation = rotation / 90;
        this.x = x;
        this.y = y;
    }
    public Node make()
    {
        Node building = null;

        return building;
    }
}
