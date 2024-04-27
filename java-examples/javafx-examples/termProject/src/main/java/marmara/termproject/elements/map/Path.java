package marmara.termproject.elements.map;

import java.util.ArrayList;

public class Path {
    private static ArrayList<Path> paths = new ArrayList<>();
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

    private Path(int pathNumber, String pathElement, ArrayList<Double> xCors, ArrayList<Double> yCors) {
        this.pathNumber = pathNumber;
        this.pathElement = pathElement;
        this.xCors = xCors;
        this.yCors = yCors;
    }
    public static void addInstance(int pathNumber, String pathElement, double x, double y)
    {
        for (Path path : paths)
            if (path.pathNumber == pathNumber)
            {
                path.xCors.add(x);
                path.yCors.add(y);
                return;
            }
        Path path = new Path(pathNumber, pathElement, new ArrayList<Double>(), new ArrayList<Double>());
        path.xCors.add(x);
        path.yCors.add(y);
        paths.add(path);
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

    public static Path getPath(int pathNumber)
    {
        for (Path path : paths)
            if (path.pathNumber == pathNumber)
                return path;
        return null;
    }

    public static ArrayList<Path> getPaths() {
        return paths;
    }
}
