package edu.anu.retrogame2018s2_frogger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.PlayerInfo;
import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.SQLiteDataBase;

public class RankDatabaseHelper extends SQLiteOpenHelper implements SQLiteDataBase {

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
    public void addData(PlayerInfo playerInfo) {

    }

    @Override
    public ArrayList<PlayerInfo> getData() {
        return null;
    }
}
