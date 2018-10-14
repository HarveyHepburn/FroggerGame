package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Background {
    private Scene scene;
    private FrogPaint frogPaint;

    Background(Scene scene) {
        this.scene = scene;
        frogPaint = new FrogPaint();
        frogPaint.setColor("#90caf9");
    }

    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawImage("background_river",0, scene.getGameSetting().get("riverTop"), scene.getGameSetting().getWidth(), scene.getGameSetting().get("riverBottom"),frogPaint);
//        frogCanvas.drawRect(0, scene.getGameSetting().get("riverTop"), scene.getGameSetting().getWidth(), scene.getGameSetting().get("riverBottom"), frogPaint);
    }
}
