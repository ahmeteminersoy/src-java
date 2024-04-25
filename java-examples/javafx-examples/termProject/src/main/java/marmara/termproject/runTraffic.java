package marmara.termproject;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class runTraffic extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String inputTextAddress = "/Users/ahmeteminersoy/Documents/src/src-java/java-examples/src-java-homework/src/input.txt";
        try {
            FileReader fileReader = new FileReader(inputTextAddress);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            for (String str : lines) {
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

    public static void main(String[] args) {
        launch();
    }
    public static void execute(String [] tokens)
    {
        switch (tokens[0])
        {
            case "Metadata" -> {

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
}