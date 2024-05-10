package marmara.termproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import marmara.termproject.elements.items.Building;
import marmara.termproject.elements.items.Car;
import marmara.termproject.elements.items.RoadTile;
import marmara.termproject.elements.map.MetaData;
import marmara.termproject.elements.map.MyPath;
import marmara.termproject.elements.map.TrafficLight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Ahmet Emin Ersoy 150123526
// Yusuf Demir 150122017
// Fecri Duman 150123851
public class runTraffic extends Application {

    public static int score;
    public static Label scoreLabel = new Label("Score: " + score);
    public static int crashes;
    public static Label crashesLabel = new Label("Crashes: " + crashes);
    public static MetaData metaData;
    private static Group primaryPane;
    private static double width;
    private static double height;
    public static ArrayList<TrafficLight> trafficLights = new ArrayList<>();
    private final static int numOfCars = 500;
    private static String inputTextAddress;

    @Override
    public void start(Stage firstStage) throws IOException {
        Image image = new Image("file:./pic.jpg");
        ImageView imageView = new ImageView(image);
        Button btn1 = new Button("level1");
        Button btn2 = new Button("level2");
        Button btn3 = new Button("level3");
        Button btn4 = new Button("level4");
        Button btn5 = new Button("level5");

        btn1.setOnAction(event -> {
            inputTextAddress = "./src/main/java/marmara/termproject/levels/level1.txt";
            startProgram(firstStage);
        });
        btn2.setOnAction(event -> {
            inputTextAddress = "./src/main/java/marmara/termproject/levels/level2.txt";
            startProgram(firstStage);
        });
        btn3.setOnAction(event -> {
            inputTextAddress = "./src/main/java/marmara/termproject/levels/level3.txt";
            startProgram(firstStage);
        });
        btn4.setOnAction(event -> {
            inputTextAddress = "./src/main/java/marmara/termproject/levels/level4.txt";
            startProgram(firstStage);
        });
        btn5.setOnAction(event -> {
            inputTextAddress = "./src/main/java/marmara/termproject/levels/level5.txt";
            startProgram(firstStage);
        });
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        VBox box = new VBox(15);

        box.setAlignment(Pos.CENTER);
        box.getChildren().add(btn1);
        box.getChildren().add(btn2);
        box.getChildren().add(btn3);
        box.getChildren().add(btn4);
        box.getChildren().add(btn5);
        root.getChildren().add(box);

        Scene scene = new Scene(root, 800, 800);
        firstStage.setTitle("Traffic Car Simulator");
        firstStage.setScene(scene);
        firstStage.show();

    }
    private void startProgram(Stage firstStage)
    {
        firstStage.close();


        Stage primaryStage = new Stage();
        readFiles(inputTextAddress);
        makeBoard();
        makeCars();
        carAnimation();
        initialize(primaryStage, primaryPane, width, height);
        primaryStage.show();


    }
    private void makeBoard()
    {
        scoreLabel.setLayoutX(10);  // X koordinatı
        scoreLabel.setLayoutY(10);  // Y koordinatı

        // Crashes Label'ını oluştur
        crashesLabel.setLayoutX(10);  // X koordinatı
        crashesLabel.setLayoutY(30);  // Y koordinatı
        primaryPane.getChildren().add(scoreLabel);
        primaryPane.getChildren().add(crashesLabel);

    }
    private void carAnimation()
    {
        Random r = new Random();
        double num = r.nextDouble(0.9, 1.4);
        Iterator<Car> carIterator = Car.getCars().iterator();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(num), event -> {
            if (carIterator.hasNext()) {
                carIterator.next().runCar();
            } else {
                Object source = event.getSource();
                if (source instanceof Timeline) {
                    ((Timeline) source).stop();
                } else {
                    System.out.println("Event source is not a Timeline: " + source.getClass());
                }
            }
        }));

        timeline.setCycleCount(runTraffic.numOfCars); // Animasyonu sürekli çalıştır
        timeline.play(); // Animasyonu başlat
    }
    private void initialize(Stage primaryStage, Group primaryPane, double width, double height)
    {
        Scene scene = new Scene(primaryPane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Traffic Control Simulator");
        primaryStage.show();
    }
    private void makeCars()
    {
        int n = MyPath.getPaths().size();
        Random r = new Random();

        for (int i = 0; i < numOfCars/*metaData.getAllowedCars()*/; i ++)
        {
            new Car(MyPath.getPath(r.nextInt(n)));
        }
    }
    private void readFiles(String inputTextAddress)
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
                trafficLights.add(trafficLight);
                primaryPane.getChildren().add(trafficLight.makeLine());
                primaryPane.getChildren().add(trafficLight.makeLight());

            }

            case "Path" -> {
                int pathNumber = Integer.parseInt(tokens[1]);
                String pathElement = tokens[2];
                double x = Double.parseDouble(tokens[3]);
                double y = Double.parseDouble(tokens[4]);
                MyPath.addInstance(pathNumber, pathElement, x, y);
            }
            default -> {
                break;
            }

        }

    }
    public static void main(String[] args) {
        launch();
    }
    public static Group getPrimaryPane() {
        return primaryPane;
    }
}