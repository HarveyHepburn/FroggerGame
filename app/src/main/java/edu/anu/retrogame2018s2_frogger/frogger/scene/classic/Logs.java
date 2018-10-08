package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Logs extends Items implements ItemManager {
    private Scene scene;

    public Logs(Scene scene) {
        this.scene = scene;
        this.add(new Lane(false, 2, 300, this, scene.getGameSetting().get("riverTop"), scene));
        this.add(new Lane(true, 4, 500, this, scene.getGameSetting().get("riverTop") + 100, scene));
        this.add(new Lane(false, 3, 350, this, scene.getGameSetting().get("riverTop") + 200, scene));
        this.add(new Lane(true, 2, 300, this, scene.getGameSetting().get("riverTop") + 300, scene));
    }

    @Override
    public ActiveItem generateNewItem(MovingParameters movingParameters) {
        return new Log(movingParameters, scene.getGameSetting());

    }
}