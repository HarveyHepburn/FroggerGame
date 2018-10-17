package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;

public class Log extends MovingItem implements MoveAlong, ActiveItem {
    public Log(MovingParameters movingParameters,GameSetting gameSetting) {
        super(movingParameters, gameSetting, (int)(calHeight(gameSetting)*2));
        this.height = (calHeight(gameSetting));
        frogPaint.setColor("#795548");
    }

    private static int calHeight(GameSetting gameSetting){
        return (gameSetting.get("riverBottom")-gameSetting.get("riverTop"))/4;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawImage("log", x,mp.getY(), x + width, (mp.getY() + height), frogPaint);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public boolean activity(Frog frog) {
        if (this.Collision(frog)) {
            frog.logOn(this);
        }
        return false;
    }

    @Override
    public void moveAlong(Spirit spirit) {
        if (spirit.getX() > 0 && spirit.getX() < gameSetting.getWidth())
            if (mp.getDir()) {
                spirit.setX(spirit.getX() + mp.getSpeed());
            } else {
                spirit.setX(spirit.getX() - mp.getSpeed());
            }
    }
}
