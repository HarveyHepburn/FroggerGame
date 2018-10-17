package edu.anu.retrogame2018s2_frogger.frogger.scene.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class LevelScene implements Scene {
    List<LevelButton> levelButtons;
    GameSetting gameSetting;

    public LevelScene(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
        levelButtons = new ArrayList<>();
        Random random = new Random();
        int gap = gameSetting.getWidth() / (gameSetting.get("levels") + 1);
        for (int i = 0; i < gameSetting.get("levels"); i++) {
            int y = i % 2 == 0 ? 300 : 700;
            y += random.nextBoolean() ? 60 : 0;
            levelButtons.add(new LevelButton(gap * (i + 1), y, i + 1, gameSetting));
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
        return "welcome";
    }

    @Override
    public boolean isMoveble(int x, int y) {
        return false;
    }

    @Override
    public String onTouch(float x, float y, boolean isDown) {
        for (LevelButton levelButton : this.levelButtons) {
            if (levelButton.isClickOn(x, y))
                return "level_" + levelButton.level;
        }
        return null;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public GameSetting getGameSetting() {
        return this.gameSetting;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawImage("levelchoose_background", 0, 0, getGameSetting().getWidth(), getGameSetting().getHeight(), null);
        for (LevelButton levelButton : this.levelButtons) {
            levelButton.draw(frogCanvas);
        }
    }

    @Override
    public void step() {
        for (LevelButton levelButton : this.levelButtons) {
            levelButton.step();
        }
    }
}
