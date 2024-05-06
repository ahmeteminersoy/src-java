package marmara.carmovement;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CarAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Pane oluştur
        Pane pane = new Pane();

        // Dikdörtgeni tanımla (arabayı temsil ediyor)
        Rectangle rect = new Rectangle(0, 0, 50, 100);
        rect.setFill(Color.BLUE);

        // Animasyon path'ini oluştur
        Path path = new Path();
        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new LineTo(20, 200));
        path.getElements().add(new LineTo(200, 200));
        path.getElements().add(new LineTo(200, 20));

        // Path üzerinde animasyonu ayarla
        PathTransition transition = new PathTransition();
        transition.setNode(rect);
        transition.setPath(path);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setDuration(Duration.seconds(10));
        transition.setCycleCount(1);
        transition.setOnFinished(e -> rect.setVisible(false)); // Animasyon bittiğinde dikdörtgeni gizle

        // Pane'e dikdörtgeni ekle ve animasyonu başlat
        pane.getChildren().add(rect);
        transition.play();

        // Sahneyi kur ve göster
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Car Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
