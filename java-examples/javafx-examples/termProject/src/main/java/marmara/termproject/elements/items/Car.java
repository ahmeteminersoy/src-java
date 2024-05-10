package marmara.termproject.elements.items;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import marmara.termproject.elements.items.abstracts.item;
import marmara.termproject.elements.map.MyPath;
import marmara.termproject.elements.map.TrafficLight;
import marmara.termproject.runTraffic;

import java.util.ArrayList;

import static marmara.termproject.runTraffic.*;

public class Car extends item {


    private static final ArrayList<TrafficLight> trafficLights = runTraffic.trafficLights;



    private static final ArrayList<Car> cars = new ArrayList<>();
    private static final ArrayList<Car> carsThatRuns = new ArrayList<>();
    private static int count = 0;
    private static final double mNum = metaData.getWidth() / metaData.getCellsInXDirection();

    private final MyPath myPath;
    private PathTransition pathTransition;


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
                ", count=" + count +
                '}';
    }

    public void runCar()
    {
        try
        {
            getPrimaryPane().getChildren().add(rectangle);
            spawnCar();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    private void spawnCar() {
        final boolean [] isFinished = {false};
        double length = calculatePathLength(myPath.getPath());
        double speed = 90; // pixels per second
        double durationInSeconds = length / speed;
        carsThatRuns.add(this);

        this.pathTransition = new PathTransition();
        this.pathTransition.setNode(this.rectangle);
        pathTransition.setPath(myPath.getPath());
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setDuration(Duration.seconds(durationInSeconds));
        pathTransition.setOnFinished(event -> {
            handleCarFinish();
            isFinished[0] = true;
        });
        if (isFinished[0])
        {
            pathTransition = null;
            carsThatRuns.remove(this);
            getPrimaryPane().getChildren().remove(rectangle);
            return;
        }

        pathTransition.play();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateCar();
            }
        }.start();




    }


    private boolean checkTrafficLights() {
        for (TrafficLight light : trafficLights) {
            if (!(light.isGreen()) && rectangle.getBoundsInParent().intersects(light.getCircle().getBoundsInParent())) {
                return false;
            }
        }
        return true;
    }
    private void handleCarFinish() {
        carsThatRuns.remove(this);
        score++;
        updateScoreDisplay();
        this.pathTransition.stop();
        getPrimaryPane().getChildren().remove(rectangle);
    }

    private void updateCar() {
        if (!checkTrafficLights()) {
            pathTransition.pause();
        } else if (checkCollisions()) {
            handleCollision();
            crashes++;
            updateCrashDisplay();
        } else if (pathTransition.getStatus() != Animation.Status.RUNNING) {
            pathTransition.play();
        }
    }

    private void updateScoreDisplay() {
        Platform.runLater(() -> scoreLabel.setText("Score: " + score));
    }

    private void updateCrashDisplay() {
        Platform.runLater(() -> crashesLabel.setText("Crashes: " + crashes));
    }
    private void handleCollision() {


        carsThatRuns.remove(this);
        rectangle.setFill(Color.RED);
        pathTransition.pause();

        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));


        pause.setOnFinished(e -> {
            getPrimaryPane().getChildren().remove(pathTransition.getNode());
            pathTransition.play();
        });

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
    private double calculatePathLength(Path path) {
        double totalLength = 0;
        double lastX = 20, lastY = 20; // Başlangıç noktası
        for (PathElement element : path.getElements()) {
            if (element instanceof MoveTo move) {
                lastX = move.getX();
                lastY = move.getY();
            } else if (element instanceof LineTo line) {
                double deltaX = line.getX() - lastX;
                double deltaY = line.getY() - lastY;
                totalLength += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
                lastX = line.getX();
                lastY = line.getY();
            }
        }
        return totalLength;
    }

    public static int getCount() {
        return count;
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public PathTransition getPathTransition() {
        return pathTransition;
    }
}
