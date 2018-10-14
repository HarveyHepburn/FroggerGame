package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;


import java.util.Random;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Car extends MovingItem implements ActiveItem {
    public Car(MovingParameters movingParameters, Scene scene) {
        super(movingParameters, scene.getGameSetting());
        frogPaint.setColor("#ff5252");
        this.scene = scene;
    }

    Scene scene;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        Random random = new Random(1);
        int res = random.nextInt(4);
        String pic = "";
        switch (res) {
            case 0:
                pic = "car_blue";
                break;
            case 1:
                pic = "car_green";
                break;
            case 2:
                pic = "car_red";
                break;
            case 3:
                pic = "car_yellow";
                break;


        }
        frogCanvas.drawImage(pic,x,mp.getY(),x+getWidth(),mp.getY()+height,frogPaint);
    }


    @Override
    public boolean activity(Frog frog) {
        if (this.Collision(frog)) {
            scene.sceneOver(new DialogInformation("Your frog got hit by a car!"));
            return true;
        }
        return false;
    }
}