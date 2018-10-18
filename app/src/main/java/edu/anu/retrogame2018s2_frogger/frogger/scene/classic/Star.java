package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import java.util.Random;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
//draw and manage the star in the game. It randomly created, if frog eat it, add time,
//and another start will be create.
public class Star extends Collision implements Spirit, Drawable {
    int x;
    int y;
    int radius;
    Scene scene;
    boolean display = true;
    Timer timer;

    Random random;

    Star(Scene scene, Timer timer) {
        random = new Random();

        this.x = random.nextInt(scene.getGameSetting().getWidth());
        this.y = random.nextInt(scene.getGameSetting().getHeight() - scene.getGameSetting().get("riverTop"));
        this.y += scene.getGameSetting().get("riverTop");
        this.radius = 30;
        this.scene = scene;
        this.timer = timer;
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
        frogCanvas.drawImage("star", x - radius, y - radius, x + radius, y + radius, null);
    }

    @Override
    public void step() {
        if (this.collision(scene.getGameSetting().getFrog(), x, y, radius, radius)) {
            this.x = random.nextInt(scene.getGameSetting().getWidth());
            this.y = random.nextInt(scene.getGameSetting().getHeight());
            timer.addTime(10);//add 10s
        }
    }
}
