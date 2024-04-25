package marmara.termproject.elements.items;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import marmara.termproject.elements.items.abstracts.item;

public class Building extends item {
    public double width;
    public double height;
    public int xCellNumber;
    public int yCellNumber;
    private int type;

    private int rotation;
    private Color color;
    private int x;
    private int y;

    public Building(int type,int rotation, int color,  int x, int y) {
        this.type = type;
        if (color == 0)
        {
            this.color = Color.CORAL;
        }
        else if (color == 1) {
            this.color = Color.LIGHTBLUE;
        }
        else if (color == 2) {
            this.color = Color.DARKRED;
        }
        else if (color == 3) {
            this.color = Color.RED;
        }


        this.rotation = rotation / 90;
        this.x = x;
        this.y = y;
    }
    public Node make()
    {
        Rectangle building = makeRectangle();
        building.setFill(color);



        return building;
    }
    public Rectangle makeRectangle()
    {
        if (type == 0)
        {
            if (rotation == 0 | rotation == 2)
            {
                Rectangle rectangle = new Rectangle(x  * width / xCellNumber, y * height / yCellNumber,
                        2 *(width / xCellNumber),3 *(height / yCellNumber));
                return  rectangle;

            }
            else
            {
                Rectangle rectangle = new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                        2 *(width / xCellNumber),3 *(height / yCellNumber));
                return  rectangle;
            }
        }
        if (type == 1)
        {
            if (rotation == 0 | rotation == 2)
            {
                Rectangle rectangle = new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                        2 *(width / xCellNumber),3 *(height / yCellNumber));
                return  rectangle;

            }
            else
            {
                Rectangle rectangle = new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                        2 *(width / xCellNumber),3 *(height / yCellNumber));
                return  rectangle;
            }
        }
        if (type == 2)
        {
            Rectangle rectangle = new Rectangle((x - 1) * width / xCellNumber, (y - 1) * height / yCellNumber,
                    width / xCellNumber, height / yCellNumber);

            return rectangle;
        }
        return null;
    }

}
