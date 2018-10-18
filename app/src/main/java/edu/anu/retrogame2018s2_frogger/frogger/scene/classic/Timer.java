package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Timer implements Drawable {
    FrogPaint frogPaint;
    long startTime = System.currentTimeMillis();
    Scene scene;
    int time;

    Timer(Scene scene) {
        this.scene = scene;
        frogPaint = new FrogPaint();
        frogPaint.setColor("#ffffff");
        frogPaint.setTextSize(60);
        frogPaint.setTextAlign(FrogPaint.TextAlign.Center);
        time = 60 * scene.getGameSetting().get("holeNumber");
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        if (time < 10) frogPaint.setColor("#FF0000");
        frogCanvas.drawText( time + "s", scene.getGameSetting().getWidth() * 0.9f, scene.getGameSetting().getHeight() * 0.05f, frogPaint);
    }

    @Override
    public void step() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime >= 1000) {
            time -= 1;
            startTime = currentTime;
        }
        if (time <= 0) {
            scene.sceneOver(new DialogInformation("Time out"));
        }
    }

    public void addTime(int add) {
        time += add;
    }

    public int getTime() {
        return time;
    }
}
