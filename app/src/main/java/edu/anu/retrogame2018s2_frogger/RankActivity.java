package edu.anu.retrogame2018s2_frogger;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import edu.anu.retrogame2018s2_frogger.frogger.PlayerInfo;

public class RankActivity extends AppCompatActivity {
    private RankDatabaseHelper dbHelper;
    String name;
    int level;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rank);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        level = intent.getIntExtra("level", 0);
        time = intent.getIntExtra("time", 0);

        dbHelper = new RankDatabaseHelper(this, "RankStore.db", null, 1);
        dbHelper.getWritableDatabase();//if there is no database, it will create
        addToDB();
        System.out.println("Add to DB!!!!!!!");

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

        TextView showData = findViewById(R.id.showData);
        StringBuilder sb = new StringBuilder();
        ArrayList<PlayerInfo> playersData = new ArrayList<>();

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
            showData.setText(sb.toString());
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables sticky immersive mode.
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
