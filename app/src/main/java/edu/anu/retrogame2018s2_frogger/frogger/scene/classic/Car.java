package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.SceneEndInformation;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Car extends MovingItem implements ActiveItem {
    Scene scene;

    public Car(MovingParameters movingParameters, Scene scene) {
        super(movingParameters, scene.getGameSetting());
        frogPaint.setColor("#ff5252");
        this.scene = scene;
    }


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public boolean activity(Frog frog) {
        if (this.Collision(frog)) {
            scene.sceneOver(new SceneEndInformation(false, "Your frog got hit by a car!"));
            return true;
        }
        return false;
    }
}
