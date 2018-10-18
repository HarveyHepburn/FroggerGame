package edu.anu.retrogame2018s2_frogger.frogger.scene.welcome;


import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.animation.ScalingAnimation;
import edu.anu.retrogame2018s2_frogger.frogger.widget.FrogButton;
/*
    Author: Danny Feng
 */
public class WelcomeButton extends FrogButton {
    String fileName;

    public WelcomeButton(int x, int y, String fileName) {
        super(x, y, fileName);
        this.fileName = fileName;
    }


    protected ScalingAnimation getAnimation() {
        return new ScalingAnimation(0.3f, 20, -10);
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        int size = animation.scaling(getSize());
        frogCanvas.drawImage(fileName, x - size, y - size / 2, x + size, y + size / 2, null);
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
