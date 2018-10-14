package edu.anu.retrogame2018s2_frogger.frogger.widget;



import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.animation.ScalingAnimation;

public abstract class FrogButton implements Drawable {
    protected int x, y;
    String text;
    FrogPaint frogPaint;
    FrogPaint textPaint;
    protected ScalingAnimation animation;

    public FrogButton(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;

        this.frogPaint = new FrogPaint();
        animation = getAnimation();
        frogPaint.setColor(getBgColor());
        frogPaint.setStyleFill(true);
        this.textPaint = getTextPaint();
//        this.textPaint=new FrogPaint();
//        textPaint.setColor(getTextColor());
//        textPaint.setTextAlign(FrogPaint.TextAlign.Center);
//        textPaint.setTextSize(80);
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawCircle(x, y, animation.scaling(getSize()), this.frogPaint);
        frogCanvas.drawText(text, x, y, textPaint);
    }

    @Override
    public void step() {
        this.animation.step();
    }

    public boolean isClickOn(float x, float y) {
        if (Math.hypot(this.x - x, this.y - y) < animation.scaling(getSize())) {
            return true;
        }
        return false;
    }

    //Factory design pattern
    protected abstract ScalingAnimation getAnimation();

    protected abstract String getBgColor();

    protected abstract FrogPaint getTextPaint();

    protected abstract int getSize();
}
