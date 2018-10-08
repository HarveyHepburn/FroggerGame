package edu.anu.retrogame2018s2_frogger.frogger;

import edu.anu.retrogame2018s2_frogger.frogger.animation.Animation;

public class Dialog implements Drawable {
    DialogInformation dialogInformation;
    //GameSetting gameSetting;//contains the screen's height and width
    Animation animation;
    int width;
    int height;
//    public Dialog(DialogInformation dialogInformation,GameSetting gameSetting) {
//        this.dialogInformation = dialogInformation;
//        this.gameSetting =gameSetting;
//    }


    @Override
    public void draw(FrogCanvas frogCanvas) {
        //frogCanvas.drawRect();

    }

    @Override
    public void step() {
        this.animation.step();
    }

    //distinguish whether is clicked
    public boolean gotClick(float x, float y) {
        //x,y is in the dialog
        return true;
        //not in

    }

}
