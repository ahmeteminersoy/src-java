package marmara.termproject.elements.items;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
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
            this.color = Color.LIGHTGREEN;
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
            Rectangle rectangle = new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                    2 * (width / xCellNumber), 3 * (height / yCellNumber));

            if (rotation == 0 | rotation == 2) {
                return new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                        2 * (width / xCellNumber), 3 * (height / yCellNumber));
            }


            else {
                return new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                        3 *(width / xCellNumber),2 *(height / yCellNumber));
            }


        }
        if (type == 1)
        {



                if (rotation == 0 | rotation == 2) {
                    return new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                            2 *(width / xCellNumber),3 *(height / yCellNumber));

                }
                else {
                    return new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                            3 * (width / xCellNumber), 2 * (height / yCellNumber));
                }


        }
        if (type == 2)
        {
            Rectangle rectangle = new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                    width / xCellNumber, height / yCellNumber);

            switch (rotation)
            {
                case 0-> {
                    return rectangle;

                }
                case 1-> {
                    rectangle.setRotate(90);
                    return rectangle;

                }
                case 2-> {
                    rectangle.setRotate(180);
                    return rectangle;

                }
                case 3-> {
                    rectangle.setRotate(270);
                    return rectangle;

                }
            }
        }
        return null;
    }
}



