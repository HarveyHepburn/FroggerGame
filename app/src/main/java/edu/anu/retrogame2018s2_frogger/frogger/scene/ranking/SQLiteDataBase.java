package edu.anu.retrogame2018s2_frogger.frogger.scene.ranking;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.PlayerInfo;

public interface SQLiteDataBase {
    void addData(PlayerInfo playerInfo);
    ArrayList<PlayerInfo> getData();
}
