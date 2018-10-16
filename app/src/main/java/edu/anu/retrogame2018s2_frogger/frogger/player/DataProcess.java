package edu.anu.retrogame2018s2_frogger.frogger.player;

import java.util.prefs.Preferences;

public class DataProcess {
    Preferences preferences = Preferences.userNodeForPackage(DataProcess.class);

    public String load() {
        return preferences.get("NAME", "");
    }

    public void save(String name) {
        DataProcess data = new DataProcess();
        data.preferences.put("NAME", name);
    }

}
