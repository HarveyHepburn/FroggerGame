package edu.anu.retrogame2018s2_frogger.frogger;

import java.util.HashMap;

import edu.anu.retrogame2018s2_frogger.frogger.player.DataProcess;
import edu.anu.retrogame2018s2_frogger.frogger.player.Player;
import edu.anu.retrogame2018s2_frogger.frogger.scene.HelpScene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.classic.ClassicFroggerScene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.level.LevelScene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.RankingScene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.DBManager;
import edu.anu.retrogame2018s2_frogger.frogger.scene.welcome.WelcomeScene;
import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;
/**
 * @Author: Yu Yang (Harvey), Boyuan Zheng(Joe)
 */
public class FroggerGame implements Drawable {
    DataProcess dataProcess=new DataProcess();
    GameSetting gameSetting;
    Scene currentScene;
    public FroggerGame(int width, int height, SoundControl soundControl,DBManager dbManager) {
        scenes = new HashMap<>();
        scenes.put("welcome", WelcomeScene.class);
        scenes.put("levels", LevelScene.class);
        scenes.put("level_1", ClassicFroggerScene.class);
        scenes.put("level_2", ClassicFroggerScene.class);
        scenes.put("level_3", ClassicFroggerScene.class);
        scenes.put("level_4", ClassicFroggerScene.class);
        scenes.put("level_5", ClassicFroggerScene.class);
        scenes.put("ranking", RankingScene.class);
        scenes.put("help", HelpScene.class);
        gameSetting = new GameSetting(width, height);

        gameSetting.setPlayer(new Player(dataProcess.load()));

        gameSetting.setSoundControl(soundControl);
        gameSetting.put("levels", 5);
        gameSetting.setDbManager(dbManager);
        currentScene = SceneFactory.getScene(scenes.get("welcome"), gameSetting);

    }

    HashMap<String, Class> scenes;



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
            String next = currentScene.onTouch(x, y, isDown);
            if (isDown) {
                changeScene(next);
            }
        }
    }

    private void changeScene(String next) {
        if (next != null) {
            String[] strings = next.split("_");
            if (strings.length > 1) {
                gameSetting.put("holeNumber", Integer.parseInt(strings[1]));
            }
            currentScene = SceneFactory.getScene(scenes.get(next), gameSetting);
        }
    }

    public void onBackPressed(BackLanbda backLanbda) {
        String next = currentScene.onBackPressed();
        if(next!=null&&next=="welcome_activity"){
            backLanbda.back();
            return;
        }
        changeScene(next);
    }

    public interface BackLanbda{
        void back();
    }

}
