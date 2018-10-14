package edu.anu.retrogame2018s2_frogger.frogger.scene.welcome;


import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.animation.ScalingAnimation;
import edu.anu.retrogame2018s2_frogger.frogger.widget.FrogButton;

public class WelcomeButton extends FrogButton {

    public WelcomeButton(int x, int y, String text) {
        super(x, y, text);
    }


    protected ScalingAnimation getAnimation() {
        return new ScalingAnimation(0.3f, 20, -10);
    }

    @Override
    protected String getBgColor() {
        return "#00838f";
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
