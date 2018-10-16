package edu.anu.retrogame2018s2_frogger.frogger.scene.ranking;


import java.util.prefs.Preferences;

public class Score {
    public void load() {
        Preferences preference = Preferences.userNodeForPackage(Score.class);
    }
}
