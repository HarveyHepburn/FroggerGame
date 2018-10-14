package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;


import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Car extends MovingItem implements ActiveItem {
    public Car(MovingParameters movingParameters, Scene scene) {
        super(movingParameters,scene.getGameSetting());
        frogPaint.setColor("#ff5252");
        this.scene=scene;
    }

    Scene scene;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public boolean activity(Frog frog) {
        if (this.Collision(frog)) {
            scene.sceneOver(new DialogInformation("Your frog got hit by a car!"));
            return true;
        }
        return false;
    }
}