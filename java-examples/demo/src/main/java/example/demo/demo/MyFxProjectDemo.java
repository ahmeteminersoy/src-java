package example.demo.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MyFxProjectDemo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button button = new Button("OK");
        Scene scene = new Scene(button, 600, 100);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Stage newStage = new Stage();
        newStage.setTitle("New Stage");
        newStage.setScene(new Scene(new Button("New Button"), 150, 150));
        newStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}