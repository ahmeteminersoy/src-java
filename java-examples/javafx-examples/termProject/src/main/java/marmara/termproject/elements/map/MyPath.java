package marmara.termproject.elements.map;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.util.ArrayList;

public class MyPath extends Path {
    private static final ArrayList<MyPath> myPaths = new ArrayList<>();
    private int pathNumber;
    private Path path;


    private MyPath(int pathNumber, Path path) {
        this.pathNumber = pathNumber;
        this.path = path;
    }
    public static void addInstance(int pathNumber, String pathElement, double x, double y)
    {
        for (MyPath myPath : myPaths)
            if (myPath.pathNumber == pathNumber)
            {

                if (pathElement.equals("MoveTo"))
                {
                    MoveTo moveTo = new MoveTo(x, y);
                    myPath.path.getElements().add(moveTo);
                } else if (pathElement.equals("LineTo")) {
                    LineTo lineTo = new LineTo(x, y);
                    myPath.path.getElements().add(lineTo);
                }

                return;
            }
        Path path = new Path();
        if (pathElement.equals("MoveTo"))
        {
            MoveTo moveTo = new MoveTo(x, y);
            path.getElements().add(moveTo);
        } else if (pathElement.equals("LineTo")) {
            LineTo lineTo = new LineTo(x, y);
            path.getElements().add(lineTo);
        }
        myPaths.add(new MyPath(pathNumber, path));

    }

    public int getPathNumber() {
        return pathNumber;
    }

    public void setPathNumber(int pathNumber) {
        this.pathNumber = pathNumber;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyPath{" +
                "pathNumber=" + pathNumber +
                ", path=" + path +
                '}';
    }
    public static MyPath getPath(int pathNumber)
    {
        for (MyPath myPath : myPaths)
            if (myPath.pathNumber == pathNumber)
                return myPath;
        return null;
    }

    public static ArrayList<MyPath> getPaths() {
        return myPaths;
    }
}
