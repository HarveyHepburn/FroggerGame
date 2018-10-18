package edu.anu.retrogame2018s2_frogger.frogger.animation;

import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
/*
    Author: Yang Yu
 */
public class FadeInAndOutAnimation extends Animation {

    boolean fadeIn = true;

    public FadeInAndOutAnimation(int speed) {
        super(speed, 255, 0);
    }

    @Override
    public void step() {
        super.step();

    }

    public FrogPaint makePaint(FrogPaint frogPaint) {
        if (frogPaint.getColor() == null) return frogPaint;
        String color = frogPaint.getColor();
        color = color.substring(1, color.length());
        if (current < 16) {
            color = "#0" + Integer.toHexString((int) current) + color;
        } else {
            color = "#" + Integer.toHexString((int) current) + color;
        }
        frogPaint.setColor(color);
        return frogPaint;
    }
}
