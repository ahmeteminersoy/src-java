package marmara.termproject;

import javafx.animation.AnimationTimer;

class Traffic
{


    private void createTraffic() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }
    /*private void update() {
        time += 0.16;
    //Implement the logic for cars checking other cars or
        lights here
        if(time > 2) {
            if(Math.random() < 0.3) {
                spawnCar();
            }
            time = 0;
        }
    }

     */
}