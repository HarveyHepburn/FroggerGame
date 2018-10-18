package edu.anu.retrogame2018s2_frogger.frogger.scene;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;

/*
    Author: Danny Feng
 */

//Show the game instruction by a image
public class HelpScene implements Scene {
    GameSetting gameSetting;

    public HelpScene(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    @Override
    public void onEnterScene(FrogCanvas frogCanvas) {

    }

    @Override
    public void onFinishScene(FrogCanvas frogCanvas) {

    }

    @Override
    public void sceneOver(DialogInformation dialogInformation) {

    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public String onBackPressed() {
        return "welcome";
    }

    @Override
    public boolean isMoveble(int x, int y) {
        return false;
    }

    @Override
    public String onTouch(float x, float y, boolean isDown) {
        return null;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public GameSetting getGameSetting() {
        return null;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawImage("help", 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);

    }

    @Override
    public void step() {

    }
}
