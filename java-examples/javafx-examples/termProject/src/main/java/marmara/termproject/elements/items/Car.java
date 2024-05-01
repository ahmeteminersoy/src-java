package marmara.termproject.elements.items;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import marmara.termproject.elements.items.abstracts.item;
import marmara.termproject.elements.map.MyPath;
import marmara.termproject.elements.map.TrafficLight;
import marmara.termproject.runTraffic;

import java.util.Random;

import static marmara.termproject.runTraffic.metaData;
import static marmara.termproject.runTraffic.trafficLights;

public class Car extends item {


    private int count = 0;
    private double x, y;
    private final MyPath myPath;
    private final Circle circle;


    public Car(MyPath myPath) {
        this.x = myPath.getxCors().getFirst();
        this.y = myPath.getyCors().getFirst();
        this.myPath = myPath;
        Circle circle = new Circle(0.09*(metaData.getWidth() / metaData.getCellsInXDirection()));
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
        for (TrafficLight light : trafficLights) {
            if (matchesLightPosition(x, y, light) && !light.isGreen()) {
                return;  // Eğer sonraki pozisyon bir kırmızı ışıkta ise dur
            }
        }
        try {
            this.x = myPath.getxCors().get(count);
            this.y = myPath.getyCors().get(count);
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
    private boolean matchesLightPosition(double x, double y, TrafficLight light) {
        return Math.abs(light.getX1() - x) < 20 && Math.abs(light.getY1() - y) < 20;  // Basit pozisyon kontrolü
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
