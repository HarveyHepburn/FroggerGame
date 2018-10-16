package edu.anu.retrogame2018s2_frogger.frogger.scene.ranking;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.PlayerInfo;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class RankingScene implements Scene {
    GameSetting gameSetting;
    public RankingScene(GameSetting gameSetting) {
        this.gameSetting=gameSetting;
    }

    @Override
    public void onEnterScene(FrogCanvas frogCanvas) {
        dbHelper = new RankDatabaseHelper(MyApplication.getContext(), "RankStore.db", null, 1);
        dbHelper.getWritableDatabase();//if there is no database, it will create
        addToDB();
        getFromDB();
    }

    @Override
    public void onFinishScene(FrogCanvas frogCanvas) {

    }

    @Override
    public void sceneOver(DialogInformation dialogInformation) {

    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public String onBackPressed() {
        return null;
    }

    @Override
    public boolean isMoveble(int x, int y) {
        return false;
    }

    @Override
    public String onTouch(float x, float y, boolean isDown) {
        return null;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public GameSetting getGameSetting() {
        return null;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        ArrayList<PlayerInfo> playerInfos = new ArrayList<PlayerInfo>();
        playerInfos.add(new PlayerInfo("Jinwei",3,10));
        playerInfos.add(new PlayerInfo("Jinwei",4,10));
        drawReal(frogCanvas,playerInfos );

    }

    public void drawReal(FrogCanvas frogCanvas, ArrayList<PlayerInfo> playerInfos) {
        int x = 20;
        int y = 100;
        FrogPaint frogPaint=new FrogPaint();
        frogPaint.setTextSize(100);
        for (PlayerInfo i : playerInfos) {
            frogCanvas.drawText(i.getName() +" "+ i.getLevel() +" " + i.getTime(), x, y, frogPaint);
            x += 40;
            y += 100;
        }

    }

    @Override
    public void step() {

    }
}
