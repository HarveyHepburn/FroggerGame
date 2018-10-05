package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;


import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;

public abstract class MovingItem implements Drawable {
    int width = 100;
    int height;
    MovingParameters mp;
    FrogPaint frogPaint;
    int x;
//    GameSetting gameSetting;

    public int getX() {
        return x;
    }
//    MovingItem(MovingParameters mp, GameSetting gameSetting) {
//        this.x=mp.calX(width);
//        this.mp = mp;
//        frogPaint = new FrogPaint();
//        height = 50;
//        this.gameSetting=gameSetting;
//    }

    public void resetItem(MovingParameters movingParameters) {
        this.mp = movingParameters;
        this.x = x;
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

    public boolean Collision(Frog frog) {
        if (frog.getY() < mp.getY() + this.height && frog.getY() >= mp.getY()) {
            if (frog.getX() + frog.getRadius() >= this.x && frog.getX() - frog.getRadius() <= this.x + this.width) {
                return true;
            }
        }
        return false;
    }

    public boolean outOfMap() {
//        if (mp.getDir()) {
//            if (this.x > gameSetting.getWidth()) {
//                return true;
//            }
//        } else {
//            if (this.x + this.width < 0) {
//                return true;
//            }
//        }
        return false;
    }
}
