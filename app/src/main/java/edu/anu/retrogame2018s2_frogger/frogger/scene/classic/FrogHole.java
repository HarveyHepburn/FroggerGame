package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import android.transition.Scene;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;

public class FrogHole implements Drawable {
    private Scene scene;
    private FrogPaint frogPaint;
    static final int HOLES_NUMBER = 4;

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogPaint = new FrogPaint();
        frogPaint.setColor("#770618"); // land color
        for(int i = 0; i < HOLES_NUMBER; i++) {
//            float x = i * (scene.getGameSetting().getWidth()/HOLES_NUMBER) + 10;
//            frogCanvas.drawCircle(x, getGameSetting().get("riverTop"), 10, frogPaint);
        }
    }

    @Override
    public void step() {
        //Frog Hole doesn't move
    }
}
