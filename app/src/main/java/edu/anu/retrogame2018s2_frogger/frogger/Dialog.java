package edu.anu.retrogame2018s2_frogger.frogger;


import edu.anu.retrogame2018s2_frogger.frogger.animation.FadeInAndOutAnimation;

public class Dialog implements Drawable {

    public DialogInformation dialogInformation;
    GameSetting gameSetting;
    FadeInAndOutAnimation animation;
    FrogPaint textPaint;
    FrogPaint bgPaint;
    FrogPaint infoPaint;
    int width = 1300;
    int height = 500;

    public Dialog(DialogInformation dialogInformation, GameSetting gameSetting) {
        this.dialogInformation = dialogInformation;
        this.gameSetting = gameSetting;
        animation=new FadeInAndOutAnimation(6);

        bgPaint = new FrogPaint();
        bgPaint.setColor(dialogInformation.getBackgroudColor());
        bgPaint.setStyleFill(true);


        infoPaint = new FrogPaint();
        infoPaint.setColor("#FFFFFF");
        infoPaint.setTextSize(80);
        infoPaint.setTextAlign(FrogPaint.TextAlign.Center);


        textPaint = new FrogPaint();
        textPaint.setColor("#000000");
        textPaint.setTextSize(80);
        textPaint.setTextAlign(FrogPaint.TextAlign.Center);
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        textPaint.setColor("#ff0000");
        int left = (gameSetting.getWidth() - width) / 2;
        int top = (gameSetting.getHeight() - height) / 2;
        frogCanvas.drawRoundRect(left, top, left + width, top + height, 20, 20, bgPaint);
        frogCanvas.drawText(dialogInformation.getInformation(), gameSetting.getWidth() / 2, gameSetting.getHeight() / 2, infoPaint);
        frogCanvas.drawText("Click to continue",gameSetting.getWidth() / 2, gameSetting.getHeight() / 2+200,animation.makePaint(textPaint));
    }

    @Override
    public void step() {
        animation.step();
    }

    public boolean gotClick(float x,float y){
        int left = (gameSetting.getWidth() - width) / 2;
        int top = (gameSetting.getHeight() - height) / 2;
        if(x>left&&x<left+width){
            if(y>top&&left<top+height){
                return true;
            }
        }
        return false;
    }
}
