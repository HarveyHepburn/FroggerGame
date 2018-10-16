package edu.anu.retrogame2018s2_frogger.frogger.scene.ranking;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import edu.anu.retrogame2018s2_frogger.MyApplication;
import edu.anu.retrogame2018s2_frogger.R;
import edu.anu.retrogame2018s2_frogger.RankDatabaseHelper;
import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.PlayerInfo;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class RankingScene implements Scene {
    GameSetting gameSetting;
    private RankDatabaseHelper dbHelper;
    String name;
    int level;
    int time;
    ArrayList<PlayerInfo> playersData = new ArrayList<>();

    public RankingScene(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    @Override
    public void onEnterScene(FrogCanvas frogCanvas) {
        dbHelper = new RankDatabaseHelper(MyApplication.getContext(), "RankStore.db", null, 1);
        dbHelper.getWritableDatabase();//if there is no database, it will create
        addToDB();
        getFromDB();
    }

    public void addToDB() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("level", level);
        values.put("time", time);
        db.insert("Rank", null, values);
    }

    public void getFromDB() {

        StringBuilder sb = new StringBuilder();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Rank", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {

            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int level = cursor.getInt(cursor.getColumnIndex("level"));
                int time = cursor.getInt(cursor.getColumnIndex("time"));

                PlayerInfo pi = new PlayerInfo(name, level, time);

                playersData.add(pi);

            } while (cursor.moveToNext());
        }
        cursor.close();
        Collections.sort(playersData);
        //get finished, now to sort and display the data

        for (PlayerInfo p : playersData) {
            String str = p.getName() + "   Level: " + p.getLevel() + "   Time: " + p.getTime() + "s" + "\n";
            Log.d("aaaa", str);
            sb.append(str);
        }
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
        playersData.add(new PlayerInfo("Jinwei", 3, 10));
        playersData.add(new PlayerInfo("Jinwei", 4, 10));
        drawReal(frogCanvas, playersData);

    }

    public void drawReal(FrogCanvas frogCanvas, ArrayList<PlayerInfo> playerInfos) {
        int x = 20;
        int y = 100;
        FrogPaint frogPaint = new FrogPaint();
        frogPaint.setTextSize(100);
        for (PlayerInfo i : playerInfos) {
            frogCanvas.drawText(i.getName() + " " + i.getLevel() + " " + i.getTime(), x, y, frogPaint);
            x += 40;
            y += 100;
        }

    }

    @Override
    public void step() {

    }
}
