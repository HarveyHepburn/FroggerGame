package edu.anu.retrogame2018s2_frogger.frogger;

import java.util.HashMap;

import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.DBManager;
import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;
/*
    Author: Danny Feng, Yu Yang
 */

//GameSetting creates and manages all the game control system include sound, database
public class GameSetting extends HashMap<String, Integer> {

    private Frog frog;

    private SoundControl soundControl;


    private DBManager dbManager;

    public SoundControl getSoundControl() {
        return soundControl;
    }


    public void setDbManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public DBManager getDbManager() {
        return dbManager;
    }

    public void setSoundControl(SoundControl soundControl) {
        this.soundControl = soundControl;
    }

    public GameSetting(int width, int height) {
        this.put("width", width);
        this.put("height", height);
        this.put("riverTop", (int) (height * 0.07));
        int roadBottom = (int) (height * 0.4);
        int a = (roadBottom - this.get("riverTop")) % 4;
        this.put("riverBottom", roadBottom - a);
        this.put("roadTop", (int) (height * 0.46));
        this.put("roadBottom", (int) (height * 0.76));
    }

    public void setFrog(Frog frog) {
        this.frog = frog;
    }

    public Frog getFrog() {
        return frog;
    }

    public int getWidth() {
        return get("width");
    }

    public int getHeight() {
        return get("height");
    }
}

