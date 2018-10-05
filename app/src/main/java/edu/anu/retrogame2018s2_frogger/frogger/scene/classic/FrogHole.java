package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import android.transition.Scene;

import java.util.Set;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;

public class FrogHole implements Drawable {
    private FrogPaint frogPaint;
    FrogPaint frogPaintBg;
    FrogPaint frogPaintHole;
    FrogPaint frogPaintHoleIn;
    private Scene scene;
    static final int HOLES_NUMBER = 4;
    Set<Integer> inHoleNum;
    int wallHeight;
    int holeWidth;

    public FrogHole(Scene scene) {
        this.scene = scene;
// this.add(new Lane(false,0,300,this,900,scene));
        // I don't know the order of these parameters
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogPaint = new FrogPaint();
        frogPaint.setColor("#770618"); // land color
        for (int i = 0; i < HOLES_NUMBER; i++) {
//            float x = i * (scene.getGameSetting().getWidth()/HOLES_NUMBER) + 10;
//            frogCanvas.drawCircle(x, getGameSetting().get("riverTop"), 10, frogPaint);
        }
    }

    public boolean inHole(Frog frog) {
        return false;
    }

    public boolean isFinished() {
        return false;
    }

    public boolean isOkToMove(int a, int b) {
        return false;
    }

    @Override
    public void step() {
        //Frog Hole doesn't move
    }
}
