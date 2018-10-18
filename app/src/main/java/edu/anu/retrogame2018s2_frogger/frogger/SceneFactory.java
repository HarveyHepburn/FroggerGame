package edu.anu.retrogame2018s2_frogger.frogger;

import java.lang.reflect.Constructor;

import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
/*
    Author: Yang Yu
 */
public class SceneFactory {
    public static Scene getScene(Class c, GameSetting gameSetting) {
        try {
            Constructor constructor = c.getConstructor(GameSetting.class);
            Scene scene = (Scene) constructor.newInstance(gameSetting);
            return scene;
        } catch (Exception e) {
            e.getCause().printStackTrace();
        }
        return null;
    }
}
