package marmara.termproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import marmara.termproject.elements.items.Building;
import marmara.termproject.elements.items.Car;
import marmara.termproject.elements.items.RoadTile;
import marmara.termproject.elements.map.MetaData;
import marmara.termproject.elements.map.Path;
import marmara.termproject.elements.map.TrafficLight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class runTraffic extends Application {
    public static MetaData metaData;
    private static Pane primaryPane;
    private static double width;
    private static double height;

    @Override
    public void start(Stage primaryStage) throws IOException {
        String inputTextAddress = "/Users/ahmeteminersoy/Desktop/level1.txt";
        readFiles(inputTextAddress, primaryStage);


        initialize(primaryStage, primaryPane, width, height);
        Car[] cars = makeCars();
        runCars(cars);
    }
    private void initialize(Stage primaryStage, Pane primaryPane, double width, double height)
    {
        Scene scene = new Scene(primaryPane, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Car[] makeCars()
    {
        int n = Path.getPaths().size();
        Random r = new Random();

        Car [] cars = new Car[metaData.getAllowedCars()];
        for (int i = 0; i < cars.length; i ++)
        {
            cars[i] = new Car(Path.getPath(r.nextInt(n)));
        }

        return cars;
    }
    private void runCars(Car[] cars)

    {
        Timeline timeline = new Timeline();
        int[] count = {0};
        for(Car car: cars) {
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.9 * (count[0] + 1)), event -> {

                getPrimaryPane().getChildren().add(car.makeCar());
                car.createTraffic();

            });
            timeline.getKeyFrames().add(keyFrame);
            count[0]++;
        }

        timeline.play();
    }
    private void readFiles(String inputTextAddress, Stage primaryStage)
    {
        try {
            FileReader fileReader = new FileReader(inputTextAddress);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            for (String str : lines)
            {
                if (str.isEmpty())
                    continue;
                String[] tokens = str.split(" ");
                execute(tokens);
            }


        }
        catch (RuntimeException | IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void execute(String [] tokens)
    {
        switch (tokens[0])
        {
            case "Metadata" -> {
                int xDirectionCells, yDirectionCells, paths, winGame, allowedCars;

                width = Double.parseDouble(tokens[1]);
                height = Double.parseDouble(tokens[2]);
                xDirectionCells = Integer.parseInt(tokens[3]);
                yDirectionCells = Integer.parseInt(tokens[4]);
                paths = Integer.parseInt(tokens[5]);
                winGame = Integer.parseInt(tokens[6]);
                allowedCars = Integer.parseInt(tokens[7]);

                metaData = new MetaData(width, height, xDirectionCells, yDirectionCells, paths, winGame, allowedCars);
                primaryPane = metaData.make();
            }
            case "Building" -> {
                int type = Integer.parseInt(tokens[1]);
                int color = Integer.parseInt(tokens[2]);
                int rotation = Integer.parseInt(tokens[3]);
                int x = Integer.parseInt(tokens[4]);
                int y = Integer.parseInt(tokens[5]);
                Building building = new Building(type, color, rotation, x, y);
                building.width = width;
                building.height = height;
                building.xCellNumber = metaData.getCellsInXDirection();
                building.yCellNumber = metaData.getCellsInYDirection();

                primaryPane.getChildren().add(building.make());

            }
            case "RoadTile" -> {
                int type = Integer.parseInt(tokens[1]);
                int rotation = Integer.parseInt(tokens[2]);
                int x = Integer.parseInt(tokens[3]);
                int y = Integer.parseInt(tokens[4]);
                RoadTile roadTile = new RoadTile(type, rotation, x, y);
                roadTile.height = height;
                roadTile.width = width;
                roadTile.xCellNumber = metaData.getCellsInXDirection();
                roadTile.yCellNumber = metaData.getCellsInYDirection();


                primaryPane.getChildren().add(roadTile.make());
            }
            case "TrafficLight" -> {
                double x1 = Double.parseDouble(tokens[1]);
                double y1 = Double.parseDouble(tokens[2]);
                double x2 = Double.parseDouble(tokens[3]);
                double y2 = Double.parseDouble(tokens[4]);
                TrafficLight trafficLight = new TrafficLight(x1, y1, x2, y2);
                primaryPane.getChildren().add(trafficLight.makeLine());
                primaryPane.getChildren().add(trafficLight.makeLight());

            }

            case "Path" -> {
                int pathNumber = Integer.parseInt(tokens[1]);
                String pathElement = tokens[2];
                double x = Double.parseDouble(tokens[3]);
                double y = Double.parseDouble(tokens[4]);
                Path.addInstance(pathNumber, pathElement, x, y);
            }
            default -> {
                break;
            }

        }

    }
    public static void main(String[] args) {
        launch();
    }
    public static Pane getPrimaryPane() {
        return primaryPane;
    }
}