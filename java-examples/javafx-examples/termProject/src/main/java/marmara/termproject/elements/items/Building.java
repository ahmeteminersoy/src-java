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
            Rectangle rectangle = new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                    2 * (width / xCellNumber), 3 * (height / yCellNumber));

            switch (rotation)
                    {
                        case 0-> {
                            return rectangle;

                        }
                        case 1-> {
                            rectangle.setRotate(90);
                            System.out.println(rectangle);
                            rectangle.setX(x * width / xCellNumber);
                            rectangle.setY(y * height / yCellNumber);
                            System.out.println(rectangle);
                            return rectangle;

                        }
                        case 2-> {
                            rectangle.setRotate(180);
                            return rectangle;

                        }
                        case 3-> {
                            rectangle.setRotate(270);
                            rectangle.setX(x * width / xCellNumber);
                            rectangle.setY( y * height / yCellNumber);
                            return rectangle;

                        }
                    }


        }
        if (type == 1)
        {

                Rectangle rectangle = new Rectangle(x * width / xCellNumber, y * height / yCellNumber,
                        2 *(width / xCellNumber),3 *(height / yCellNumber));
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
