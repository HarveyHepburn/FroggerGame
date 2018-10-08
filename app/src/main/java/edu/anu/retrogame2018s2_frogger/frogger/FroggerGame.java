package edu.anu.retrogame2018s2_frogger.frogger;




import java.util.HashMap;

import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.classic.ClassicFroggerScene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.level.LevelScene;

public class FroggerGame implements Drawable {
    GameSetting gameSetting;
    Scene currentScene;

    public FroggerGame(int width, int height) {
        classes = new HashMap<>();
        classes.put(0,LevelScene.class);
        classes.put(1,ClassicFroggerScene.class);
        classes.put(2,ClassicFroggerScene.class);
        classes.put(3,ClassicFroggerScene.class);
        classes.put(4,ClassicFroggerScene.class);
        classes.put(5,ClassicFroggerScene.class);
        gameSetting = new GameSetting(width, height);
        gameSetting.put("levels", 5);
        currentScene = SceneFactory.getScene(classes.get(0), gameSetting);
    }

    HashMap<Integer,Class> classes;

    public GameSetting getGameSetting() {
        return gameSetting;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        if (currentScene != null) {
            currentScene.draw(frogCanvas);

            if (!currentScene.isActive()) {
                currentScene.onFinishScene(frogCanvas);
            }
        }
    }


    @Override
    public void step() {
        if (currentScene != null) {
            currentScene.step();
        }
    }

    public void onTouch(float x, float y, boolean isDown) {
        if (this.currentScene != null) {
            Integer result = currentScene.onTouch(x, y, isDown);
            if (result != null && isDown) {
                if(result==0){
                    currentScene = SceneFactory.getScene(LevelScene.class, gameSetting);
                }else {
                    gameSetting.put("holeNumber",result);
                    currentScene = SceneFactory.getScene(ClassicFroggerScene.class, gameSetting);
                }
            }
        }
    }
}
