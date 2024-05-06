package marmara.termproject.elements.items;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import marmara.termproject.elements.items.abstracts.item;
import marmara.termproject.elements.map.MyPath;
import marmara.termproject.elements.map.TrafficLight;
import marmara.termproject.runTraffic;

import java.util.ArrayList;
import java.util.Random;

import static marmara.termproject.runTraffic.*;

public class Car extends item {
    private static double time;


    private static final ArrayList<TrafficLight> trafficLights = runTraffic.trafficLights;



    private static final ArrayList<Car> cars = new ArrayList<>();
    private static final ArrayList<Car> carsThatRuns = new ArrayList<>();
    private static int count = 0;
    private static final double mNum = metaData.getWidth() / metaData.getCellsInXDirection();

    private final MyPath myPath;


    private final Rectangle rectangle;


    public Car(MyPath myPath) {
        count++;
        this.myPath = myPath;
        Rectangle rectangle = new Rectangle(0, 0, 0.2 * (mNum), 0.1 * (mNum));
        rectangle.setFill(Color.BLUE);
        this.rectangle = rectangle;
        cars.add(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "myPath=" + myPath +
                '}';
    }

    public void runCar()
    {
        try
        {
            spawnCar();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    private void update()
    {

    }
    private void spawnCar()
    {
        carsThatRuns.add(this);

        PathTransition transition = new PathTransition();
        transition.setNode(this.rectangle);
        transition.setPath(myPath.getPath());
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setDuration(Duration.seconds(10));
        transition.setCycleCount(1);

        transition.setOnFinished(e -> rectangle.setVisible(false));
        getPrimaryPane().getChildren().add(rectangle);
        transition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            if (!checkTrafficLights()) {
                transition.pause();
            } else if (checkCollisions()) {
                transition.pause();
                handleCollision();
            }
            //TODO
            else {
                transition.play();
            }
        });
        transition.play();

    }
    private boolean checkTrafficLights() {
        for (TrafficLight light : trafficLights) {
            if (!(light.isGreen()) && rectangle.getBoundsInParent().intersects(light.getCircle().getBoundsInParent())) {
                return false;
            }
        }
        return true;
    }
    private void handleCollision() {
        carsThatRuns.remove(this);
        rectangle.setFill(Color.RED);  // Çarpışma durumunda arabanın rengini değiştir.
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.setOnFinished(e -> rectangle.setVisible(false));  // 0.5 saniye sonra araba kaybolur.
        pause.play();
    }
    private boolean checkCollisions() {
        for (Car otherCar : carsThatRuns) {
            if (otherCar != this && rectangle.getBoundsInParent().intersects(otherCar.rectangle.getBoundsInParent())) {
                otherCar.handleCollision();
                return true;
            }
        }
        return false;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Car.count = count;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
    public static ArrayList<Car> getCars() {
        return cars;
    }
}
