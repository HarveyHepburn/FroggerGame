package edu.anu.retrogame2018s2_frogger.frogger.animation;

/*
    Author: Yang Yu
 */

public class ScalingAnimation extends Animation {

    public ScalingAnimation(float speed, float max, float min) {
        super(speed, max, min);
    }

    @Override
    public void step() {
        super.step();
    }

    public int scaling(int original) {
        return original += current;
    }

}
