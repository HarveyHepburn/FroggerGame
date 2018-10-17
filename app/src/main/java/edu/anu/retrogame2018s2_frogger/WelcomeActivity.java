package edu.anu.retrogame2018s2_frogger;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.player.DataProcess;


public class WelcomeActivity extends AppCompatActivity {
    private DataProcess dataProcess = new DataProcess();
    private GameSetting gameSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_welcome);

        TextView textView = (TextView) findViewById(R.id.toast);
        if (dataProcess.load().equals("")) {
            String text = "Welcome, please sign up";
            textView.setText(text);
        } else {
            String name = dataProcess.load();
            String text = "Welcome back, " + name;
            textView.setText(text);

        }
    }


    public void submit(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        RankDatabaseHelper rankDatabaseHelper = new RankDatabaseHelper();

        if (rankDatabaseHelper.playerExist(name)) {
            Toast.makeText(getApplicationContext(), "Already exits!Please change another one!", Toast.LENGTH_LONG).show();
        } else if (name == "") {
            Toast.makeText(getApplicationContext(), "Can't sign up! Please change another one!", Toast.LENGTH_LONG).show();
        } else {
            //add to database
            rankDatabaseHelper.addData(new RecordInfo(name, -1, -1));//-1 means no player
            DataProcess dataProcess = new DataProcess();
            dataProcess.save(name);
        }

    }

    public void login(View view) {
        if (dataProcess.load().equals("")) {
            Toast.makeText(getApplicationContext(), "You haven't sign up yet", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
            String name = dataProcess.load();
            gameSetting.getPlayer().setName(name);
        }
    }

    public void logout(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        DataProcess dataProcess = new DataProcess();
        dataProcess.save("");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            hideSystemUI();
//        }
    }

//    private void hideSystemUI() {
//        // Enables sticky immersive mode.
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                        // Set the content to appear under the system bars so that the
//                        // content doesn't resize when the system bars hide and show.
//                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        // Hide the nav bar and status bar
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
//    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
//    private void showSystemUI() {
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//    }
}
