package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;

/*
    Author: Yang Yu
 */
public abstract class MovingItem extends Collision implements Drawable {
    int width;
    int height;
    MovingParameters mp;
    FrogPaint frogPaint;
    int x;
    GameSetting gameSetting;

    public int getX() {
        return x;
    }

    MovingItem(MovingParameters mp, GameSetting gameSetting, int width) {
        this.width = width;
        this.mp = mp;
        this.x = mp.calX(width);
        frogPaint = new FrogPaint();
        this.gameSetting = gameSetting;
    }

    public void resetItem(MovingParameters movingParameters) {
        this.mp = movingParameters;
        this.x = mp.calX(width);
    }

    @Override
    public void step() {
        if (mp.getDir()) {
            this.x += mp.getSpeed();
        } else {
            this.x -= mp.getSpeed();
        }
    }

    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawRect(x, mp.getY(), x + width, mp.getY() + height, frogPaint);
    }

    public boolean Collision(Spirit spirit) {
        return collision(spirit, this.x, mp.getY(), this.height, width);
    }

    public boolean outOfMap() {
        if (mp.getDir()) {
            if (this.x > gameSetting.getWidth()) {
                return true;
            }
        } else {
            if (this.x + this.width < 0) {
                return true;
            }
        }
        return false;
    }
}
