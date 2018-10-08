package edu.anu.retrogame2018s2_frogger.frogger.scene.level;



import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;

public class LevelButton implements Drawable {
    int x, y, level;
    FrogPaint frogPaint;
    FrogPaint textPaint;
    ScalingAnimation animation;

    public LevelButton(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.frogPaint = new FrogPaint();
        animation=new ScalingAnimation(0.3f,20,-10);
        frogPaint.setColor("#4dd0e1");
        frogPaint.setStyleFill(true);
        this.textPaint=new FrogPaint();
        textPaint.setColor("#ffffff");
        textPaint.setTextAlign(FrogPaint.TextAlign.Center);
        textPaint.setTextSize(80);
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawCircle(x,y,animation.scaling(200),this.frogPaint);
        frogCanvas.drawText("level "+level,x,y,textPaint);
    }

    @Override
    public void step() {
        this.animation.step();
    }

    boolean isClickOn(float x,float y){
        if(Math.hypot(this.x-x, this.y-y)<animation.scaling(200)){
            return true;
        }
        return false;
    }
}
