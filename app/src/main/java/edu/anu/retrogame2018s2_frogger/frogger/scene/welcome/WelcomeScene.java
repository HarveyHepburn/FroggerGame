package edu.anu.retrogame2018s2_frogger.frogger.scene.welcome;


import java.util.HashMap;
import java.util.Map;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.player.PlayerStore;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
import edu.anu.retrogame2018s2_frogger.frogger.widget.FrogButton;

public class WelcomeScene implements Scene {
    GameSetting gameSetting;
    Map<String, FrogButton> buttons = new HashMap<>();

    public WelcomeScene(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
        buttons.put("levels", new WelcomeButton((int) (getGameSetting().getWidth() * 0.8), (int) (getGameSetting().getHeight() * 0.8), "start_game"));
        buttons.put("help", new WelcomeButton((int) (getGameSetting().getWidth() * 0.15), (int) (getGameSetting().getHeight() * 0.2), "questionmark"));
        buttons.put("ranking", new WelcomeButton((int) (getGameSetting().getWidth() * 0.2), (int) (getGameSetting().getHeight() * 0.8), "ranking"));
        if (!gameSetting.getSoundControl().isMusicPlaying()) {
            gameSetting.getSoundControl().playMusic("welcome_music.mp3");
        }
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
        return "welcome_activity";
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
        return gameSetting;
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

        //draw player name text in the center
        FrogPaint frogPaint;
        frogPaint = new FrogPaint();
        frogPaint.setColor("#56a341");
        frogPaint.setTextSize(100);
        frogPaint.setTextAlign(FrogPaint.TextAlign.Center);

        String name = PlayerStore.load();
        frogCanvas.drawText(name, getGameSetting().getWidth() * 0.5f, getGameSetting().getHeight() * 0.8f, frogPaint);
    }

    @Override
    public void step() {
        for (Drawable drawable : buttons.values()) {
            drawable.step();
        }
    }
}

