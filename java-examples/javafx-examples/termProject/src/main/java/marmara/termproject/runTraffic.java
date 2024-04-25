package marmara.termproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import marmara.termproject.elements.map.MetaData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class runTraffic extends Application {
    private static Pane primaryPane;
    private static double width;
    private static double height;

    @Override
    public void start(Stage primaryStage) throws IOException {
        String inputTextAddress = "/Users/ahmeteminersoy/Desktop/level1.txt";
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
                execute(tokens, primaryStage);
            }
        }
        catch (RuntimeException | IOException e)
        {
            System.out.println(e.getMessage());
        }
        Scene scene = new Scene(primaryPane, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void execute(String [] tokens, Stage primaryStage)
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

                MetaData metaData = new MetaData(width, height, xDirectionCells, yDirectionCells, paths, winGame, allowedCars);
                primaryPane = metaData.make();
            }
            case "Building" -> {

            }
            case "RoadTile" -> {

            }
            case "TrafficLight" -> {

            }
            case "Path" -> {

            }
            default -> {
                break;
            }

        }

    }
    public static void main(String[] args) {
        launch();
    }
}