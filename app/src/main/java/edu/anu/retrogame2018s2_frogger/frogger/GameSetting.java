package edu.anu.retrogame2018s2_frogger.frogger;

import java.util.HashMap;

import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

public class GameSetting extends HashMap<String,Integer> {

    private Frog frog;

    private SoundControl soundControl;

    private Player player;

    public SoundControl getSoundControl() {
        return soundControl;
    }

    public void setSoundControl(SoundControl soundControl) {
        this.soundControl = soundControl;
    }

    public GameSetting(int width, int height) {
        this.put("width",width);
        this.put("height",height);
        this.put("riverTop",100);
        this.put("riverBottom",500);
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

