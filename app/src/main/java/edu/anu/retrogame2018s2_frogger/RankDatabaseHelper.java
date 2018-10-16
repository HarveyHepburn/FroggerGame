package edu.anu.retrogame2018s2_frogger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.SQLiteDataBase;

public class RankDatabaseHelper extends SQLiteOpenHelper implements SQLiteDataBase {
    private RankDatabaseHelper dbHelper;

    public static final String CREATE_RANK = "create table Rank ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "level integer, "
            + "time integer)";

    private Context mContext;

    public RankDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RANK);
        Toast.makeText(mContext, "Create database succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void addData(RecordInfo playerInfo) {
        dbHelper = new RankDatabaseHelper(MyApplication.getContext(), "RankStore.db", null, 1);
        dbHelper.getWritableDatabase();//if there is no database, it will create

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", playerInfo.getName());
        values.put("level", playerInfo.getLevel());
        values.put("time", playerInfo.getTime());
        db.insert("Rank", null, values);
    }

    @Override
    public ArrayList<RecordInfo> getData() {
        dbHelper = new RankDatabaseHelper(MyApplication.getContext(), "RankStore.db", null, 1);
        dbHelper.getWritableDatabase();//if there is no database, it will create
        StringBuilder sb = new StringBuilder();
        ArrayList<RecordInfo> playersData = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
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
}
