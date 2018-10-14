package edu.anu.retrogame2018s2_frogger.frogger.scene.welcome;


import java.util.HashMap;
import java.util.Map;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
import edu.anu.retrogame2018s2_frogger.frogger.widget.FrogButton;

public class WelcomeScene implements Scene {
    GameSetting gameSetting;
    Map<String, FrogButton> buttons = new HashMap<>();

    public WelcomeScene(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
        buttons.put("levels", new WelcomeButton(gameSetting.getWidth() - 200, gameSetting.getHeight() - 200, "Start Game"));
        buttons.put("setting", new WelcomeButton(200, 200, "Game Setting"));
        gameSetting.getSoundControl().playMusic("welcome_music.mp3");
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
        return null;
    }

    @Override
    public boolean isMoveble(int x, int y) {
        return false;
    }

    @Override
    public String onTouch(float x, float y, boolean isDown) {
        if (isDown) {
            for (String key : buttons.keySet()) {
                if (buttons.get(key).isClickOn(x, y)) {
                    return key;
                }
            }
        }
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
        int l = gameSetting.getWidth() / 2 - 569 / 2;
        int r = gameSetting.getWidth() / 2 + 569 / 2;
        int t = gameSetting.getHeight() / 2 - 510 / 2;
        int b = gameSetting.getHeight() / 2 + 510 / 2;

        int l1 = gameSetting.getWidth() / 2 - 600;
        int r1 = gameSetting.getWidth() / 2 + 600;
        int t1 = 10;
        int b1 = 10 + 400;
        frogCanvas.drawImage("logo", l1, t1, r1, b1, new FrogPaint());
        frogCanvas.drawImage("home_frogger", l, t + 50, r, b + 50, new FrogPaint());
        for (Drawable drawable : buttons.values()) {
            drawable.draw(frogCanvas);
        }
    }

    @Override
    public void step() {
        for (Drawable drawable : buttons.values()) {
            drawable.step();
        }
    }
}

