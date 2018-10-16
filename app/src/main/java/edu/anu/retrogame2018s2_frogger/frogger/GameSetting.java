package edu.anu.retrogame2018s2_frogger.frogger;

import java.util.HashMap;

import edu.anu.retrogame2018s2_frogger.frogger.player.Player;
import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.DBManager;
import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

public class GameSetting extends HashMap<String, Integer> {

    private Frog frog;

    private SoundControl soundControl;

    private Player player;

    private DBManager dbManager;

    public SoundControl getSoundControl() {
        return soundControl;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
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
        this.put("riverTop", 100);
        this.put("riverBottom", 500);
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

