package edu.anu.retrogame2018s2_frogger.frogger.player;

import java.util.prefs.Preferences;

public class PlayerStore {
    public static String load() {
        Preferences preferences = Preferences.userNodeForPackage(PlayerStore.class);
        return preferences.get("NAME", "");
    }

    public static void save(String name) {
        Preferences preferences = Preferences.userNodeForPackage(PlayerStore.class);
        preferences.put("NAME", name);
    }

}
