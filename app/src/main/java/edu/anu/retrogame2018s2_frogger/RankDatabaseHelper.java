package edu.anu.retrogame2018s2_frogger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;

import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.DBManager;

//this is the main code for game data base (used SQL)
public class RankDatabaseHelper extends SQLiteOpenHelper implements DBManager {

    public static final String CREATE_RANK = "create table Rank ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "level integer, "
            + "time integer)";

    private Context mContext;

    public RankDatabaseHelper() {
        super(MyApplication.getContext(), "RankStore.db", null, 1);
        mContext = MyApplication.getContext();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RANK);
        //create database
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void addData(RecordInfo playerInfo) {
        SQLiteDatabase db = getWritableDatabase();//if there is no database, it will create
        ContentValues values = new ContentValues();

        values.put("name", playerInfo.getName());
        values.put("level", playerInfo.getLevel());
        values.put("time", playerInfo.getTime());
        db.insert("Rank", null, values);
    }

    @Override
    public ArrayList<RecordInfo> getData() {
        ArrayList<RecordInfo> playersData = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("Rank", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {

            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int level = cursor.getInt(cursor.getColumnIndex("level"));
                int time = cursor.getInt(cursor.getColumnIndex("time"));

                RecordInfo pi = new RecordInfo(name, level, time);

                playersData.add(pi);

            } while (cursor.moveToNext());
        }
        cursor.close();
        Collections.sort(playersData);
        //get finished, now to sort and display the data

        return playersData;
    }

    @Override
    public Boolean playerExist(String name) {
        ArrayList<RecordInfo> playersData = getData();
        for (RecordInfo i : playersData) {
            if (i.getName().equals(name)) return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> getPlayer() {
        ArrayList<RecordInfo> playerData = getData();
        ArrayList<String> playerName = new ArrayList<>();
        for (RecordInfo i : playerData) {
            playerName.add(i.getName());
        }
        return playerName;
    }
}
