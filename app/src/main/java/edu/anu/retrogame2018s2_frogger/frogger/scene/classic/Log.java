package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import android.transition.Scene;

import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;

public class Log extends MovingItem implements ActiveItem { //implements MoveAlong
    private Scene scene;
    private FrogPaint frogPaint;
    int width = 100;

//    public Log (MovingParameters mp, GameSetting gs){}
    public void draw(FrogCanvas frogCanvas) {
        frogPaint = new FrogPaint();
        frogPaint.setColor("#a75f09"); // wood color
//        frogCanvas.drawRect(x, getGameSetting().get("riverBottom"), 10, frogPaint);
       //not very sure about the position

    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public boolean activity(Frog frog) {
        return false;
    }

    public void moveAlong(Frog frog) {

    }
}
