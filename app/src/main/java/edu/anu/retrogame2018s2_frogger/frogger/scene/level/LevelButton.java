package edu.anu.retrogame2018s2_frogger.frogger.scene.level;



import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
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
//    int x, y, level;
//    FrogPaint frogPaint;
//    FrogPaint textPaint;
//    ScalingAnimation animation;
//
//    public LevelButton(int x, int y, int level) {
//        this.x = x;
//        this.y = y;
//        this.level = level;
//        this.frogPaint = new FrogPaint();
//        animation=new ScalingAnimation(0.3f,20,-10);
//        frogPaint.setColor("#4dd0e1");
//        frogPaint.setStyleFill(true);
//        this.textPaint=new FrogPaint();
//        textPaint.setColor("#ffffff");
//        textPaint.setTextAlign(FrogPaint.TextAlign.Center);
//        textPaint.setTextSize(80);
//    }
//
//    @Override
//    public void draw(FrogCanvas frogCanvas) {
//        frogCanvas.drawCircle(x,y,animation.scaling(200),this.frogPaint);
//        frogCanvas.drawText("level "+level,x,y,textPaint);
//    }
//
//    @Override
//    public void step() {
//        this.animation.step();
//    }
//
//    boolean isClickOn(float x,float y){
//        if(Math.hypot(this.x-x, this.y-y)<animation.scaling(200)){
//            return true;
//        }
//        return false;
//    }
}
