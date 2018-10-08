package edu.anu.retrogame2018s2_frogger.frogger;

import java.util.HashMap;

public class GameSetting extends HashMap<String, Integer> {

    private Frog frog;

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

