package edu.anu.retrogame2018s2_frogger;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * @Author: Danny Feng
 */
public class GameActivity extends AppCompatActivity {
    GameView gameView;
    //the game activity, we overwrite the view layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hide the Title bar of this activity screen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //force to landscape mode
        setContentView(R.layout.activity_game);
        gameView = findViewById(R.id.gamer);
    }


    @Override
    public void onStop() {
        super.onStop();
        Sounds.pauseMusic();
        //pause music when user goes back to home page
    }

    @Override
    public void onResume() {
        super.onResume();
        Sounds.continuePlay();
    }

    @Override
    public void onBackPressed() {
        gameView.froggerGame.onBackPressed(() -> {
            super.onBackPressed();
        });
        //we need to override it because in the game, we wil pop-up a dialog for user to confirm
        //if they really want to quit
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.

}
