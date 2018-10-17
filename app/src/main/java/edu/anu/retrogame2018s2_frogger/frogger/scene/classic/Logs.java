package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Logs extends Items implements ItemManager {
    private Scene scene;

    public Logs(Scene scene) {
        this.scene = scene;
        int riverHeight=scene.getGameSetting().get("riverBottom")-scene.getGameSetting().get("riverTop");
        int logHeight=riverHeight/4;
        this.add(new Lane(false, 2, 300, this, scene.getGameSetting().get("riverTop"), scene));
        this.add(new Lane(true, 4, 500, this, scene.getGameSetting().get("riverTop") + logHeight, scene));
        this.add(new Lane(false, 3, 350, this, scene.getGameSetting().get("riverTop") + logHeight*2, scene));
        this.add(new Lane(true, 2, 300, this, scene.getGameSetting().get("riverTop") + logHeight*3, scene));
    }

    @Override
    public ActiveItem getNewItem(MovingParameters movingParameters) {
        return new Log(movingParameters, scene.getGameSetting());
    }
}