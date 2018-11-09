package edu.anu.retrogame2018s2_frogger.frogger.scene.ranking;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

/*
    Author: Danny Feng
 */
public class RankingScene implements Scene {
    GameSetting gameSetting;

    //show ranking
    public RankingScene(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    @Override
    public void onEnterScene(FrogCanvas frogCanvas) {

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

    @Override//if user pressed back, go back to welcome scene
    public String onBackPressed() {
        return "welcome";
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
        frogCanvas.drawImage("levelchoose_background", 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);
        //get all data in the arraylist
        ArrayList<RecordInfo> recordInfos = gameSetting.getDbManager().getData();
        drawReal(frogCanvas, recordInfos);
    }

    //draw all the records out. first three records are shown in different colour
    public void drawReal(FrogCanvas frogCanvas, ArrayList<RecordInfo> recordInfos) {
        for(int i=1;i<recordInfos.size();i++){
            if(recordInfos.get(i).compareTo(recordInfos.get(i-1))==0){
                recordInfos.remove(i);
            }
        }
        double x = 0.2 * gameSetting.getWidth();
        int y = 200;
        FrogPaint frogPaintGold = new FrogPaint();
        frogPaintGold.setColor("#ffff00");
        frogPaintGold.setTextSize(100);

        FrogPaint frogPaintSilver = new FrogPaint();
        frogPaintSilver.setColor("#e0e0e0");
        frogPaintSilver.setTextSize(100);

        FrogPaint frogPaintBrownzen = new FrogPaint();
        frogPaintBrownzen.setColor("#ffab00");
        frogPaintBrownzen.setTextSize(100);

        FrogPaint frogPaint = new FrogPaint();
        frogPaint.setTextSize(100);
        frogPaint.setColor("#ffffff");

        for (int i = 0; i < recordInfos.size(); i++) {
            if (recordInfos.get(i).getLevel() < 0 || recordInfos.get(i).getTime() < 0)
                continue;//-1 means there is no player records
            if (i == 0) {
                frogCanvas.drawText("Name" + "  " + "Level" + "   " + "Time Left", (int) x - 70, y - 100, frogPaint);
                frogCanvas.drawText(recordInfos.get(i).getName() + "      " + recordInfos.get(i).getLevel() + "       " + recordInfos.get(i).getTime() + "s", (int) x, y, frogPaintGold);
                y += 100;
            } else if (i == 1) {
                frogCanvas.drawText(recordInfos.get(i).getName() + "      " + recordInfos.get(i).getLevel() + "       " + recordInfos.get(i).getTime() + "s", (int) x, y, frogPaintSilver);
                y += 100;
            } else if (i == 2) {
                frogCanvas.drawText(recordInfos.get(i).getName() + "      " + recordInfos.get(i).getLevel() + "       " + recordInfos.get(i).getTime() + "s", (int) x, y, frogPaintBrownzen);
                y += 100;
            } else {
                frogCanvas.drawText(recordInfos.get(i).getName() + "      " + recordInfos.get(i).getLevel() + "       " + recordInfos.get(i).getTime() + "s", (int) x, y, frogPaint);
                y += 100;
            }
            //show name, level, and time(left)
        }

    }

    @Override
    public void step() {

    }
}
