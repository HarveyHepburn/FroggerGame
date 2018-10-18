package edu.anu.retrogame2018s2_frogger.frogger.scene.level;

import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.animation.ScalingAnimation;
import edu.anu.retrogame2018s2_frogger.frogger.widget.FrogButton;
/**
 * @Author: Yu Yang (Harvey), Boyuan Zheng(Joe)
 */
public class LevelButton extends FrogButton {
    int level;
    GameSetting gameSetting;
    public LevelButton(int x, int y, int level,GameSetting gameSetting) {
        super(x, y, "level " + level);
        this.level=level;
        this.gameSetting=gameSetting;
    }

    @Override
    public void draw(FrogCanvas frogCanvas){
        int size=animation.scaling(getSize());
        frogCanvas.drawImage("cloud_l"+level,x-size,y-size/2,x+size,y+size/2,null);
    }

    @Override
    protected ScalingAnimation getAnimation() {
        return new ScalingAnimation(0.3f, 20, -10);
    }

    @Override
    protected String getBgColor() {
        return "#4dd0e1";
    }

    @Override
    protected FrogPaint getTextPaint() {
        FrogPaint textPaint = new FrogPaint();
        textPaint.setColor("#ffffff");
        textPaint.setTextAlign(FrogPaint.TextAlign.Center);
        textPaint.setTextSize(70);
        return textPaint;
    }

    @Override
    protected int getSize() {
        return (int)(gameSetting.getHeight() * 0.3);
    }
}
