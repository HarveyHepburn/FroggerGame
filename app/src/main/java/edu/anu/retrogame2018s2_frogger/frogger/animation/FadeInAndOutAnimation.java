package edu.anu.retrogame2018s2_frogger.frogger.animation;

import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;

public class FadeInAndOutAnimation extends Animation {
    boolean fadeIn;

    public FadeInAndOutAnimation(float speed, float max, float min) {
        super(speed, max, min);
    }

    @Override
    public void step() {

    }

    public FrogPaint makePaint(FrogPaint frogPaint) {
        return frogPaint;
    }
}
