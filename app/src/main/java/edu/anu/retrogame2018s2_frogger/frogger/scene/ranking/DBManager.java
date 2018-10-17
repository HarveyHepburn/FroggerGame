package edu.anu.retrogame2018s2_frogger.frogger.scene.ranking;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;

public interface DBManager {
    void addData(RecordInfo playerInfo);

    ArrayList<RecordInfo> getData();

    ArrayList<String> getPlayer();

    Boolean playerExist(String name);

}
