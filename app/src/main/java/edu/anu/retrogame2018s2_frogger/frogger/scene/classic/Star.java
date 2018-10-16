package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import java.util.Random;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Star extends Collision implements Spirit, Drawable {
    int x;
    int y;
    int radius;
    Scene scene;
    boolean display = true;
    Timer timer;


    Star(Scene scene,Timer timer) {
        Random random = new Random();
        this.x = random.nextInt(scene.getGameSetting().getWidth());
        this.y = random.nextInt(scene.getGameSetting().getHeight());
        this.radius = 30;
        this.scene = scene;
        this.timer=timer;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getRadius() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        if (display)
            frogCanvas.drawImage("star", x - radius, y - radius, x + radius, y + radius, null);
    }

    @Override
    public void step() {

        if (display&&this.collision(scene.getGameSetting().getFrog(), x, y, radius, radius)) {
            display = false;
            timer.addTime(10);
        }
    }
}
