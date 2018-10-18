package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;


import java.util.Random;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Car extends MovingItem implements ActiveItem {
    static Random random = new Random();
    public Car(MovingParameters movingParameters, Scene scene) {
        super(movingParameters, scene.getGameSetting(),(int) ((calHeight(scene.getGameSetting()))*2));
        frogPaint.setColor("#ff5252");
        this.scene = scene;
        this.color = random.nextInt(4);
        height = ((gameSetting.get("roadBottom")-gameSetting.get("roadTop"))/5);
    }

    private static int calHeight(GameSetting gameSetting){
        return ((gameSetting.get("roadBottom")-gameSetting.get("roadTop"))/5);
    }


    int color;

    Scene scene;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        String pic = "";
        switch (color) {
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
        if(!mp.getDir()){
            pic+="_reverse";
        }
        frogCanvas.drawImage(pic, x, mp.getY(), x + getWidth(), mp.getY() + height, frogPaint);
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