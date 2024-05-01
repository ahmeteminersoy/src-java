package marmara.termproject.elements.map;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.Path;

import java.util.ArrayList;

public class MyPath extends Path {
    private static ArrayList<MyPath> myPaths = new ArrayList<>();
    private int pathNumber;
    private String pathElement;
    private ArrayList<Double> xCors;
    private ArrayList<Double> yCors;

    @Override
    public String toString() {
        return "Path{" +
                "pathNumber=" + pathNumber +
                ", pathElement='" + pathElement + '\'' +
                ", xCors=" + xCors +
                ", yCors=" + yCors +
                '}';
    }

    private MyPath(int pathNumber, String pathElement, ArrayList<Double> xCors, ArrayList<Double> yCors) {
        this.pathNumber = pathNumber;
        this.pathElement = pathElement;
        this.xCors = xCors;
        this.yCors = yCors;
    }
    public static void addInstance(int pathNumber, String pathElement, double x, double y)
    {
        for (MyPath myPath : myPaths)
            if (myPath.pathNumber == pathNumber)
            {
                myPath.xCors.add(x);
                myPath.yCors.add(y);
                return;
            }
        MyPath myPath = new MyPath(pathNumber, pathElement, new ArrayList<Double>(), new ArrayList<Double>());
        myPath.xCors.add(x);
        myPath.yCors.add(y);
        myPaths.add(myPath);
    }

    public ArrayList<Double> getxCors() {
        return xCors;
    }

    public void setxCors(ArrayList<Double> xCors) {
        this.xCors = xCors;
    }

    public ArrayList<Double> getyCors() {
        return yCors;
    }

    public void setyCors(ArrayList<Double> yCors) {
        this.yCors = yCors;
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
