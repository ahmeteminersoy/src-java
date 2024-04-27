package marmara.termproject.elements.items;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import marmara.termproject.elements.items.abstracts.item;
import marmara.termproject.elements.map.Path;
import marmara.termproject.runTraffic;

import java.util.Random;

import static marmara.termproject.runTraffic.metaData;

public class Car extends item {


    private int count = 0;
    private double x, y;
    private final Path path;
    private final Circle circle;


    public Car(Path path) {
        this.x = path.getxCors().getFirst();
        this.y = path.getyCors().getFirst();
        this.path = path;
        Circle circle = new Circle(0.08*(metaData.getWidth() / metaData.getCellsInXDirection()));
        circle.setCenterX(x);
        circle.setCenterY(y);
        int n =  new Random().nextInt(6);
        Color color = switch (n) {
            case 0 -> Color.BLANCHEDALMOND;

            case 1 -> Color.INDIANRED;

            case 2 -> Color.BROWN;

            case 3 -> Color.GREENYELLOW;

            case 4 -> Color.DARKKHAKI;


            default -> Color.DARKGREEN;

        };
        circle.setFill(color);
        this.circle = circle;
    }
    private void spawnCar()
    {
        try {
            this.x = path.getxCors().get(count);
            this.y = path.getyCors().get(count);
            circle.setCenterX(x);
            circle.setCenterY(y);
            count++;
            System.out.println("SPAWNED");
        }
        catch (Exception e)
        {
            disappear();
        }

    }

    private void disappear() {
        Pane pane = runTraffic.getPrimaryPane();
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.setOnFinished(event -> pane.getChildren().remove(circle));
        pause.play();

    }
    public Node makeCar()
    {
        return this.circle;
    }
    private double time;
    public void createTraffic() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }
    private void update() {
        time += 0.16;
        if(time > 2) {
            if(Math.random() < 0.3) {
                spawnCar();
            }
            time = 0;
        }
    }
}
