package lab.util;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_24_practice extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {


	Pane pane = new Pane();

    // Create a circle with x=0, y=0, radius=10. Set the color of it to ORANGE.
    Circle circle = new Circle(0, 0, 10);
    circle.setFill(Color.ORANGE);

    // Create an arch with x=125, y=80, radiusX=80, radiusY= 40, Start degree=210, length=124. Set the draw color to BLACK, fill color to WHITE.
    Arc arc = new Arc(125, 80, 80, 40, 210, 124);
    arc.setStroke(Color.BLACK);
    arc.setFill(Color.WHITE);

    // Add circle and rectangle to the pane
    pane.getChildren().add(circle);
    pane.getChildren().add(arc);


    // Create a path transition with the duration of 4 milliseconds
    PathTransition pt = new PathTransition();
    pt.setPath(arc);
    pt.setNode(circle);
    pt.setDuration(Duration.millis(4000));
    pt.setAutoReverse(true);
    pt.setCycleCount(Timeline.INDEFINITE); // This makes the animation loop
    pt.play();

    // set circle on the arc


    // Stop the circle when mouse is pressed.
    circle.setOnMousePressed(event -> {
      pt.pause();
    });


    // Move the circle when mouse is released.
    circle.setOnMouseReleased(event -> {
      pt.play();
    });
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 200);
    primaryStage.setTitle("Exercise15_24"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
