package edu.anu.retrogame2018s2_frogger.frogger.scene.level;

import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.animation.ScalingAnimation;
import edu.anu.retrogame2018s2_frogger.frogger.widget.FrogButton;

public class LevelButton extends FrogButton {
    int level;

    public LevelButton(int x, int y, int level) {
        super(x, y, "level " + level);
        this.level=level;
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
        return 200;
    }
}
