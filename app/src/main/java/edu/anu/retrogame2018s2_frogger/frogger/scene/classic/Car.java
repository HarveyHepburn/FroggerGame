package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.Frog;

public class Car extends MovingItem implements ActiveItem {
//    Scene scene;
//
//    public Car(MovingParameters movingParameters, Scene scene) {
//        super.mp = movingParameters;
//        this.scene=scene;
//    }
    


    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public boolean activity(Frog frog) {
        return false;
    }
}
