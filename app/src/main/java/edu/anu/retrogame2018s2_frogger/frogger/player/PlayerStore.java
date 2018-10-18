package edu.anu.retrogame2018s2_frogger.frogger.player;

import java.util.prefs.Preferences;

/*
    Author: Danny Feng
 */
public class PlayerStore {
    public static String load() {
        Preferences preferences = Preferences.userNodeForPackage(PlayerStore.class);
        return preferences.get("NAME", "");//load player data, default is empty string
    }

    public static void save(String name) {
        Preferences preferences = Preferences.userNodeForPackage(PlayerStore.class);
        preferences.put("NAME", name);// the key is NAME
        //this class is to save and load the current player
    }

}
